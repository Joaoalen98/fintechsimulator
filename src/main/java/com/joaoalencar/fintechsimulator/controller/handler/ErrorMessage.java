package com.joaoalencar.fintechsimulator.controller.handler;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorMessage {
    
    private String message;

    private LocalDateTime date;

    public ErrorMessage(String message) {
        this.message = message;
        date = LocalDateTime.now();
    }
}
