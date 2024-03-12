package com.joaoalencar.fintechsimulator.controller.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.joaoalencar.fintechsimulator.service.exception.BadTransferException;
import com.joaoalencar.fintechsimulator.service.exception.UserAlreadyExistsException;
import com.joaoalencar.fintechsimulator.service.exception.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoResourceFoundException.class)
    public ResponseEntity<?> handle(NoResourceFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage("Recurso nao encontrado"));
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<?> handle(UserAlreadyExistsException ex) {
        return ResponseEntity.badRequest().body(new ErrorMessage("Usuario ja existe no banco - " + ex.getMessage()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handle(UserNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorMessage("Usuario nao encontrado - " + ex.getMessage()));
    }

    @ExceptionHandler(BadTransferException.class)
    public ResponseEntity<?> handle(BadTransferException ex) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN)
                .body(new ErrorMessage("Erro na transferencia - " + ex.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handle(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorMessage("Erro interno - " + ex.getMessage()));
    }
}
