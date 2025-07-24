package com.example.football.facades;

import com.example.football.entities.dto.team.CreateTeamDTO;
import com.example.football.entities.dto.team.TeamDTO;
import com.example.football.entities.dto.team.UpdateTeamDTO;
import com.example.football.services.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamFacade {
    private final TeamService teamService;
    @Autowired
    public TeamFacade(TeamService teamService) {
        this.teamService = teamService;
    }

    public ResponseEntity<TeamDTO> get(int id) {
        return ResponseEntity.ok(TeamDTO.from(teamService.getById(id)));
    }

    public ResponseEntity<List<TeamDTO>> getAll() {
        return ResponseEntity.ok(TeamDTO.from(teamService.getAll()));
    }

    public ResponseEntity<?> create(CreateTeamDTO createTeamDTO) {
        teamService.create(createTeamDTO);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> update(UpdateTeamDTO updateTeamDTO) {
        teamService.update(updateTeamDTO);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> delete(int id) {
        teamService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}