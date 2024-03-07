package com.joaoalencar.fintechsimulator.service.dto;

import com.joaoalencar.fintechsimulator.domain.user.UserType;

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

    private String name;

    private String document;

    private String email;

    private String password;

    private UserType type;
}
