package com.example.football.services;

import com.example.football.entities.dto.transfer.NewTransferDTO;
import com.example.football.entities.models.Player;
import com.example.football.entities.models.Team;
import com.example.football.entities.models.Transfer;
import com.example.football.repositories.PlayerRepository;
import com.example.football.repositories.TeamRepository;
import com.example.football.repositories.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Service
public class TransferService {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final TransferRepository transferRepository;

    @Autowired
    public TransferService(PlayerRepository playerRepository, TeamRepository teamRepository, TransferRepository transferRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.transferRepository = transferRepository;
    }

    @Transactional
    public void transfer (NewTransferDTO dto) {
        Player player = playerRepository.findById(dto.playerId()).orElseThrow(() -> new RuntimeException("Player not found"));
        Team oldTeam = player.getTeam();

        Team newTeam = teamRepository.findById(dto.toTeamId()).orElseThrow(() -> new RuntimeException("Team not found"));

        int years = calculateAge(player.getBirthDate());
        Integer totalAmount = (int) (((double) (player.getExperienceMonths() * 100000) / years) * (1 + oldTeam.getCommissionRate()));

        if (newTeam.getBalance() >= totalAmount) {


            oldTeam.setBalance(oldTeam.getBalance() + (player.getExperienceMonths() * 100000) / years);
            teamRepository.save(oldTeam);

            newTeam.setBalance(newTeam.getBalance() - totalAmount);
            player.setTeam(newTeam);
            playerRepository.save(player);

            System.out.println("p-m: " + player.getExperienceMonths());
            System.out.println("p-b: " + player.getBirthDate());
            System.out.println("p-y: " + years);
            System.out.println("ot-plus: " + (player.getExperienceMonths() * 100000) / years);
            System.out.println("nt-minus: " + totalAmount);


            Transfer transfer = new Transfer(
                    player,
                    oldTeam,
                    newTeam,
                    oldTeam.getCommissionRate(),
                    totalAmount,
                    new Date()
            );
            transferRepository.save(transfer);
        } else  {
            throw new RuntimeException();
        }

    }

    private static int calculateAge(Date birthDate) {
        LocalDate birthLocalDate = birthDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        LocalDate now = LocalDate.now();
        return Period.between(birthLocalDate, now).getYears();
    }
}
