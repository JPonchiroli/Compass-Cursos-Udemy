package com.pbcompass.mscreditassessor.domain.model;

import java.math.BigDecimal;

public class Card {

    private Long id;
    private String name;
    private String flag;
    private BigDecimal basicLimit;

    public Card(){}

    public Card(Long id, String name, String flag, BigDecimal basicLimit) {
        this.id = id;
        this.name = name;
        this.flag = flag;
        this.basicLimit = basicLimit;
    }

    public Card(String name, String flag, BigDecimal basicLimit) {
        this.name = name;
        this.flag = flag;
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

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public BigDecimal getBasicLimit() {
        return basicLimit;
    }

    public void setBasicLimit(BigDecimal basicLimit) {
        this.basicLimit = basicLimit;
    }
}
