package com.example.football.services;

import com.example.football.entities.dto.team.CreateTeamDTO;
import com.example.football.entities.dto.team.UpdateTeamDTO;
import com.example.football.entities.models.Team;
import com.example.football.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team getById(Integer id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Team not found with id " + id));
    }

    public List<Team> getAll() {
        return teamRepository.findAll();
    }

    @Transactional
    public void create(CreateTeamDTO dto) {
        Team team = Team.builder()
                .name(dto.name())
                .commissionRate(dto.commissionRate())
                .balance(dto.balance())
                .build();
        teamRepository.save(team);
    }

    @Transactional
    public void update(UpdateTeamDTO dto) {
        Team team = getById(dto.id());
        team.setName(dto.name());
        team.setCommissionRate(dto.commissionRate());
        team.setBalance(dto.balance());
        teamRepository.save(team);
    }

    @Transactional
    public void deleteById(Integer id) {
        teamRepository.deleteById(id);
    }
}
