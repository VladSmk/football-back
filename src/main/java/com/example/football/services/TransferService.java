package com.example.football.services;

import com.example.football.entities.dto.transfer.NewTransferDTO;
import com.example.football.entities.models.Player;
import com.example.football.entities.models.Team;
import com.example.football.entities.models.Transfer;
import com.example.football.exception.domain.CustomException;
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
    public TransferService(PlayerRepository playerRepository,
                           TeamRepository teamRepository,
                           TransferRepository transferRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
        this.transferRepository = transferRepository;
    }

    @Transactional
    public void transfer(NewTransferDTO dto) {
        Player player = playerRepository.findById(dto.playerId())
                .orElseThrow(() -> new CustomException("Player not found"));
        Team oldTeam = player.getTeam();
        Team newTeam = teamRepository.findById(dto.toTeamId())
                .orElseThrow(() -> new CustomException("Team not found"));

        LocalDate birthDate = player.getBirthDate().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        int years = Period.between(birthDate, LocalDate.now()).getYears();

        Integer totalAmount = (int) (((double) player.getExperienceMonths() * 100000 / years)
                * (1 + oldTeam.getCommissionRate()));

        if (newTeam.getBalance() >= totalAmount) {
            oldTeam.setBalance(oldTeam.getBalance() + (player.getExperienceMonths() * 100000) / years);
            teamRepository.save(oldTeam);

            newTeam.setBalance(newTeam.getBalance() - totalAmount);
            player.setTeam(newTeam);
            playerRepository.save(player);

            Transfer transfer = new Transfer(
                    player,
                    oldTeam,
                    newTeam,
                    oldTeam.getCommissionRate(),
                    totalAmount,
                    new Date()
            );
            transferRepository.save(transfer);
        } else {
            throw new CustomException("Insufficient funds");
        }
    }
}