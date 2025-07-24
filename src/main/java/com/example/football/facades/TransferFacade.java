package com.example.football.facades;

import com.example.football.entities.dto.transfer.NewTransferDTO;
import com.example.football.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TransferFacade {
    private final TransferService transferService;
    @Autowired
    public TransferFacade(TransferService transferService) {
        this.transferService = transferService;
    }

    public ResponseEntity<?> transfer(NewTransferDTO dto) {
        transferService.transfer(dto);
        return ResponseEntity.ok().build();
    }
}
