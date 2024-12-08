package com.pbcompass.mscards.domain;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    @Enumerated(EnumType.STRING)
    private CardFlag flag;
    @Column
    private BigDecimal income;
    @Column(name = "card_limit")
    private BigDecimal basicLimit;

    public Card(){};

    public Card(String name, CardFlag flag, BigDecimal income, BigDecimal basicLimit) {
        this.name = name;
        this.flag = flag;
        this.income = income;
        this.basicLimit = basicLimit;
    }

    public Card(Long id, String name, CardFlag flag, BigDecimal income, BigDecimal basicLimit) {
        this.id = id;
        this.name = name;
        this.flag = flag;
        this.income = income;
        this.basicLimit = basicLimit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardFlag getFlag() {
        return flag;
    }

    public void setFlag(CardFlag flag) {
        this.flag = flag;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public BigDecimal getBasicLimit() {
        return basicLimit;
    }

    public void setBasicLimit(BigDecimal basicLimit) {
        this.basicLimit = basicLimit;
    }
}
