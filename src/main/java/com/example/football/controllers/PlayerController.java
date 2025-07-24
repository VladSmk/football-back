package com.example.football.controllers;

import com.example.football.entities.dto.player.CreatePlayerDTO;
import com.example.football.entities.dto.player.PlayerDTO;
import com.example.football.entities.dto.player.UpdatePlayerDTO;
import com.example.football.facades.PlayerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/player")
public class PlayerController {
    private final PlayerFacade playerFacade;
    @Autowired
    public PlayerController(PlayerFacade playerFacade) {
        this.playerFacade = playerFacade;
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> get(@PathVariable int id) {
        return playerFacade.get(id);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PlayerDTO>> getAll() {
        return playerFacade.getAll();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreatePlayerDTO createPlayerDTO) {
        return playerFacade.create(createPlayerDTO);
    }

    @PatchMapping
    public ResponseEntity<?> update(@RequestBody UpdatePlayerDTO updatePlayerDTO) {
        return playerFacade.update(updatePlayerDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        return playerFacade.delete(id);
    }
}