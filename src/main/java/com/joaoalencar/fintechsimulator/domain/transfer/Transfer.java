package com.joaoalencar.fintechsimulator.domain.transfer;

import java.math.BigDecimal;

import com.joaoalencar.fintechsimulator.domain.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "transfers")
@Table(name = "transfers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "payer_id")
    private Integer payerId;

    @Column(name = "payee_id")
    private Integer payeeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payer_id", insertable = false, updatable = false)
    private User payer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payee_id", insertable = false, updatable = false)
    private User payee;
}
