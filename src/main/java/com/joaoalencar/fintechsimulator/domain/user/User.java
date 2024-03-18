package com.joaoalencar.fintechsimulator.domain.user;

import java.math.BigDecimal;
import java.util.Set;

import com.joaoalencar.fintechsimulator.domain.transfer.Transfer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "users")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "document", unique = true)
    private String document;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private UserType type;

    @Column(name = "balance")
    private BigDecimal balance;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "payer")
    private Set<Transfer> debits;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "payee")
    private Set<Transfer> credits;
}
