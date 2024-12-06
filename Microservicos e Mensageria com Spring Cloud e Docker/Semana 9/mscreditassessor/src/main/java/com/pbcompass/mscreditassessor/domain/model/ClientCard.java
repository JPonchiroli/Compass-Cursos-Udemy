package com.pbcompass.mscreditassessor.domain.model;

import java.math.BigDecimal;

public class ClientCard {

    private String name;
    private String flag;
    private BigDecimal releasedLimit;

    public ClientCard(){}

    public ClientCard(String name, String flag, BigDecimal releasedLimit) {
        this.name = name;
        this.flag = flag;
        this.releasedLimit = releasedLimit;
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

    public BigDecimal getReleasedLimit() {
        return releasedLimit;
    }

    public void setReleasedLimit(BigDecimal releasedLimit) {
        this.releasedLimit = releasedLimit;
    }
}
