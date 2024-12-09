package com.pbcompass.mscreditassessor.domain.model;

import java.math.BigDecimal;

public class ClientCard {

    private String name;
    private String flag;
    private BigDecimal limitReleased;

    public ClientCard(){}

    public ClientCard(String name, String flag, BigDecimal limitReleased) {
        this.name = name;
        this.flag = flag;
        this.limitReleased = limitReleased;
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

    public BigDecimal getLimitReleased() {
        return limitReleased;
    }

    public void setLimitReleased(BigDecimal limitReleased) {
        this.limitReleased = limitReleased;
    }
}
