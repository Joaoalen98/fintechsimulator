package com.joaoalencar.fintechsimulator.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoalencar.fintechsimulator.service.TransferService;
import com.joaoalencar.fintechsimulator.service.dto.TransferDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/transfers")
public class TransferController {

    @Autowired
    private TransferService transferService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<TransferDTO>> findUserTransfers(@PathVariable Integer userId) {
        return ResponseEntity.ok(transferService.findUserTransfers(userId));
    }

    @PostMapping
    public ResponseEntity<?> createTranser(@Valid @RequestBody TransferDTO transferDTO) {
        transferService.createTransfer(transferDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
