package com.example.football.entities.dto.player;

import com.example.football.entities.models.Player;
import com.example.football.entities.models.Team;

import java.util.*;

public record PlayerDTO(
        String name,
        Date birthDate,
        Integer experienceMonths,
        TeamDTO team
) {

    public static PlayerDTO from(Player player) {
        return new PlayerDTO(
                player.getName(),
                player.getBirthDate(),
                player.getExperienceMonths(),
                TeamDTO.from(player.getTeam())
        );
    }

    public static List<PlayerDTO> from(List<Player> players) {
        return players.stream()
                .map(PlayerDTO::from)
                .toList();
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