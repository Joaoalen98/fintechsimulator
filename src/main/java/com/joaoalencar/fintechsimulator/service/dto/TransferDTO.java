package com.joaoalencar.fintechsimulator.service.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransferDTO {
    
    private Integer id;

    private BigDecimal amount;

    private Integer payerId;

    private Integer payeeId;
}
