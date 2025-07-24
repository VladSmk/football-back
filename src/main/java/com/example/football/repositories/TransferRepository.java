package com.example.football.repositories;

import com.example.football.entities.models.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Integer> {
    List<Transfer> findByPlayerId(Integer playerId);
    List<Transfer> findByFromTeamIdOrToTeamId(Integer fromTeamId, Integer toTeamId);
}
