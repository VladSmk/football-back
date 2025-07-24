package com.example.football.facades;

import com.example.football.entities.dto.player.CreatePlayerDTO;
import com.example.football.entities.dto.player.PlayerDTO;
import com.example.football.entities.dto.player.UpdatePlayerDTO;
import com.example.football.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerFacade {
    private final PlayerService playerService;
    @Autowired
    public PlayerFacade(PlayerService playerService) {
        this.playerService = playerService;
    }

    public ResponseEntity<PlayerDTO> get(int id) {
        return ResponseEntity.ok(PlayerDTO.from(playerService.getById(id)));
    }

    public ResponseEntity<List<PlayerDTO>> getAll() {
        return ResponseEntity.ok(PlayerDTO.from(playerService.getAll()));
    }

    public ResponseEntity<?> create(CreatePlayerDTO createPlayerDTO) {
        playerService.create(createPlayerDTO);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> update(UpdatePlayerDTO updatePlayerDTO) {
        playerService.update(updatePlayerDTO);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> delete(int id) {
        playerService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}