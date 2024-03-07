package com.joaoalencar.fintechsimulator.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaoalencar.fintechsimulator.domain.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findOneByDocument(String document);

    Optional<User> findOneByEmail(String email);
}
