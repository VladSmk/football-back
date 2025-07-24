package com.example.football.controllers;

import com.example.football.entities.dto.transfer.NewTransferDTO;
import com.example.football.facades.TransferFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transfer")
public class TransferController {
    private final TransferFacade transferFacade;
    @Autowired
    public TransferController(TransferFacade transferFacade) {
        this.transferFacade = transferFacade;
    }

    @PostMapping
    public ResponseEntity<?> transfer(@RequestBody NewTransferDTO newTransferDTO) {
        return transferFacade.transfer(newTransferDTO);
    }
}
