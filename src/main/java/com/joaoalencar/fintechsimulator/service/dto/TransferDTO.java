package com.joaoalencar.fintechsimulator.service.dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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

    @DecimalMin(value = "0.01", message = "Valor mínimo de transferência é R$ 0,01")
    @NotNull(message = "Nome é obrigatorio")
    private BigDecimal amount;

    @NotNull(message = "Id do pagador é obrigatorio")
    private Integer payerId;

    @NotNull(message = "Id do beneficiário é obrigatorio")
    private Integer payeeId;
}
