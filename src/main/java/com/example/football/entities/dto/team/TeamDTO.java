package com.example.football.entities.dto.team;

import com.example.football.entities.models.Player;
import com.example.football.entities.models.Team;
import java.util.*;

public record TeamDTO(
        Integer id,
        String name,
        Double commissionRate,
        Integer balance,
        List<PlayerDTO> players
) {
    public static TeamDTO from(Team team) {
        return new TeamDTO(
                team.getId(),
                team.getName(),
                team.getCommissionRate(),
                team.getBalance(),
                PlayerDTO.from(team.getPlayers())
        );
    }

    public static List<TeamDTO> from(List<Team> teams) {
        return teams.stream()
                .map(TeamDTO::from)
                .toList();
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

        public static List<PlayerDTO> from(List<Player> players) {
            return players.stream().map(PlayerDTO::from).toList();
        }
    }
}