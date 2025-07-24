package com.example.football.controllers;

import com.example.football.entities.dto.team.CreateTeamDTO;
import com.example.football.entities.dto.team.TeamDTO;
import com.example.football.entities.dto.team.UpdateTeamDTO;
import com.example.football.facades.TeamFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
public class TeamController {
    private final TeamFacade teamFacade;
    @Autowired
    public TeamController(TeamFacade teamFacade) {
        this.teamFacade = teamFacade;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDTO> get(@PathVariable int id) {
        return teamFacade.get(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<TeamDTO>> getAll() {
        return teamFacade.getAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateTeamDTO createTeamDTO) {
        return teamFacade.create(createTeamDTO);
    }

    @PatchMapping
    public ResponseEntity<?> update(@RequestBody UpdateTeamDTO updateTeamDTO) {
        return teamFacade.update(updateTeamDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return teamFacade.delete(id);
    }
}