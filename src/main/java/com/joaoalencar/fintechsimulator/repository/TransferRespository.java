package com.joaoalencar.fintechsimulator.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaoalencar.fintechsimulator.domain.transfer.Transfer;

public interface TransferRespository extends JpaRepository<Transfer, Integer> {
    
    List<Transfer> findByPayerIdOrPayeeId(Integer payerId, Integer payeeId);
}
