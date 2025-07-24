package com.example.football.entities.dto.team;

public record UpdateTeamDTO(
        Integer id,
        String name,
        Double commissionRate,
        Integer balance
) { }
