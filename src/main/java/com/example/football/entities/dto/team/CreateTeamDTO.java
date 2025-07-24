package com.example.football.entities.dto.team;


public record CreateTeamDTO(
        String name,
        Double commissionRate,
        Integer balance
) { }
