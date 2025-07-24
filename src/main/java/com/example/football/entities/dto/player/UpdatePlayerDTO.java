package com.example.football.entities.dto.player;

import java.util.Date;

public record UpdatePlayerDTO(
        Integer id,
        String name,
        Date birthDate,
        Integer experienceMonths,
        Integer teamId
) {}
