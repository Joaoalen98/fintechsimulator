package com.joaoalencar.fintechsimulator.service.dto;

import java.math.BigDecimal;

import com.joaoalencar.fintechsimulator.domain.user.UserType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    
    private Integer id;

    @NotBlank(message = "Nome não pode estar vazio")
    @NotNull(message = "Nome é obrigatorio")
    private String name;

    @NotBlank(message = "Documento não pode estar vazio")
    @NotNull(message = "Documento é obrigatorio")
    private String document;

    @NotBlank(message = "Email não pode estar vazio")
    @NotNull(message = "Email é obrigatorio")
    private String email;

    @NotBlank(message = "Senha não pode estar vazio")
    @NotNull(message = "Senha é obrigatorio")
    private String password;

    @NotNull(message = "Tipo de usuário é obrigatorio")
    private UserType type;

    @Min(value = 0, message = "Balanço inicial deve ser maior ou igual a zero")
    private BigDecimal balance;
}
