package com.example.football.services;

import com.example.football.entities.dto.player.CreatePlayerDTO;
import com.example.football.entities.dto.player.UpdatePlayerDTO;
import com.example.football.entities.models.Player;
import com.example.football.exception.domain.CustomException;
import com.example.football.repositories.PlayerRepository;
import com.example.football.repositories.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;

    public PlayerService(PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    public Player getById(Integer id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new CustomException("Player not found with id " + id));
    }

    public List<Player> getAll() {
        return playerRepository.findAll();
    }

    @Transactional
    public void create(CreatePlayerDTO dto) {
        Player player = Player.builder()
                .name(dto.name())
                .birthDate(dto.birthDate())
                .experienceMonths(dto.experienceMonths())
                .team(teamRepository.findById(dto.teamId()).orElseThrow(() -> new RuntimeException("Team not found")))
                .build();
        playerRepository.save(player);
    }

    @Transactional
    public void update(UpdatePlayerDTO dto) {
        Player player = getById(dto.id());
        player.setName(dto.name());
        player.setBirthDate(dto.birthDate());
        player.setExperienceMonths(dto.experienceMonths());
        player.setTeam(teamRepository.findById(dto.teamId()).orElseThrow(() -> new RuntimeException("Team not found")));
        playerRepository.save(player);
    }

    @Transactional
    public void deleteById(Integer id) {
        playerRepository.deleteById(id);
    }
}
