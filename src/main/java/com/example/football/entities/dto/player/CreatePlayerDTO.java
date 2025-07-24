package com.example.football.entities.dto.player;

import java.util.Date;

public record CreatePlayerDTO(
        String name,
        Date birthDate,
        Integer experienceMonths,
        Integer teamId
) {}
