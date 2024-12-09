package com.pbcompass.mscreditassessor.domain.model;

import java.math.BigDecimal;

public class CardsApproved {
    private String card;
    private String flag;
    private BigDecimal approvedLimit;

    public CardsApproved(){}

    public CardsApproved(String card, String flag, BigDecimal approvedLimit) {
        this.card = card;
        this.flag = flag;
        this.approvedLimit = approvedLimit;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public BigDecimal getApprovedLimit() {
        return approvedLimit;
    }

    public void setApprovedLimit(BigDecimal approvedLimit) {
        this.approvedLimit = approvedLimit;
    }
}
