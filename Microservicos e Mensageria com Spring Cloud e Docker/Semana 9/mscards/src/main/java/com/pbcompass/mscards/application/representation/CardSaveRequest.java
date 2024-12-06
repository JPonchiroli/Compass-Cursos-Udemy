package com.pbcompass.mscards.application.representation;

import com.pbcompass.mscards.domain.CardFlag;
import com.pbcompass.mscards.domain.Cards;

import java.math.BigDecimal;

public class CardSaveRequest {
    private String name;
    private CardFlag flag;
    private BigDecimal income;
    private BigDecimal basicLimit;

    public Cards toModel(){
        return new Cards(name, flag, income, basicLimit);
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

    public BigDecimal getLimit() {
        return basicLimit;
    }

    public void setLimit(BigDecimal basicLimit) {
        this.basicLimit = basicLimit;
    }
}
