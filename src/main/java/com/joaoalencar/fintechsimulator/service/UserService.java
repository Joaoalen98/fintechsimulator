package com.joaoalencar.fintechsimulator.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaoalencar.fintechsimulator.domain.user.User;
import com.joaoalencar.fintechsimulator.repository.UserRepository;
import com.joaoalencar.fintechsimulator.service.dto.UserDTO;
import com.joaoalencar.fintechsimulator.service.exception.UserAlreadyExistsException;
import com.joaoalencar.fintechsimulator.service.exception.UserNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<UserDTO> create(UserDTO userDTO) {
        var alreadyExists = userRepository.findOneByDocument(userDTO.getDocument());

        if (alreadyExists.isPresent()) {
            throw new UserAlreadyExistsException("Documento ja cadastrado na base.");
        }

        alreadyExists = userRepository.findOneByEmail(userDTO.getEmail());

        if (alreadyExists.isPresent()) {
            throw new UserAlreadyExistsException("Email ja cadastrado na base.");
        }

        var user = new ModelMapper().map(userDTO, User.class);
        
        if (user != null) {
            return Optional.of(new ModelMapper().map(userRepository.save(user), UserDTO.class));
        }

        return null;
    }

    public Optional<UserDTO> findById(Integer userId) {
        var user = userRepository.findById(userId);

        if (user.isEmpty()) {
            throw new UserNotFoundException();
        }

        user.get().setPassword(null);

        return Optional.of(new ModelMapper().map(user, UserDTO.class));
    }
}
