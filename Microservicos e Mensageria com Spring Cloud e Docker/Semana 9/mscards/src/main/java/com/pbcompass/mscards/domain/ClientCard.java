package com.pbcompass.mscards.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Entity
public class ClientCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String cpf;
    @ManyToOne
    @JoinColumn(name = "id_card")
    private Card card;
    @Column
    private BigDecimal limit;

    public ClientCard(){}

    public ClientCard(Long id, String cpf, Card card, BigDecimal limit) {
        this.id = id;
        this.cpf = cpf;
        this.card = card;
        this.limit = limit;
    }

    public ClientCard(String cpf, Card card, BigDecimal limit) {
        this.cpf = cpf;
        this.card = card;
        this.limit = limit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public BigDecimal getLimit() {
        return limit;
    }

    public void setLimit(BigDecimal limit) {
        this.limit = limit;
    }
}
