package com.example.football.entities.dto.transfer;

import com.example.football.entities.models.Player;
import com.example.football.entities.models.Team;
import com.example.football.entities.models.Transfer;

import javax.print.attribute.IntegerSyntax;
import java.util.*;

public record TransferDTO (
        Integer id,
        PlayerDTO player,
        TeamDTO fromTeam,
        TeamDTO toTeam,
        Double transferFee,
        Integer totalAmount,
        Date transferDate
){
    public static TransferDTO from(Transfer transfer) {
        return new TransferDTO(
                transfer.getId(),
                PlayerDTO.from(transfer.getPlayer()),
                TeamDTO.from(transfer.getFromTeam()),
                TeamDTO.from(transfer.getToTeam()),
                transfer.getTransferFee(),
                transfer.getTotalAmount(),
                transfer.getTransferDate()
        );
    }

    public static List<TransferDTO> from(List<Transfer> transfers) {
        return transfers.stream().map(TransferDTO::from).toList();
    }

    public record PlayerDTO(
            String name,
            Date birthDate,
            Integer experienceMonths
    ) {

        public static PlayerDTO from(Player player) {
            return new PlayerDTO(
                    player.getName(),
                    player.getBirthDate(),
                    player.getExperienceMonths()
            );
        }
    }

    public record TeamDTO(
            Integer id,
            String name,
            Double commissionRate,
            Integer balance
    ) {
        public static TeamDTO from(Team team) {
            return new TeamDTO(
                    team.getId(),
                    team.getName(),
                    team.getCommissionRate(),
                    team.getBalance()
            );
        }
    }
}
