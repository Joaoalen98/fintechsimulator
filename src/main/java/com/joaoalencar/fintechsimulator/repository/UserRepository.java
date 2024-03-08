package com.joaoalencar.fintechsimulator.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.joaoalencar.fintechsimulator.domain.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findOneByDocument(String document);

    Optional<User> findOneByEmail(String email);

    @Modifying
    @Query("update users set balance = balance + :debitCreditAmount where id = :userId")
    void updateBalance(Integer userId, BigDecimal debitCreditAmount);
}
