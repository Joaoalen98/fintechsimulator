package com.joaoalencar.fintechsimulator.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaoalencar.fintechsimulator.service.UserService;
import com.joaoalencar.fintechsimulator.service.dto.UserDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Optional<UserDTO>> create(@Valid @RequestBody UserDTO userDTO) {
        var user = userService.create(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Optional<UserDTO>> findById(@PathVariable Integer userId) {
        var user = userService.findById(userId);
        return ResponseEntity.ok().body(user);
    }
}
