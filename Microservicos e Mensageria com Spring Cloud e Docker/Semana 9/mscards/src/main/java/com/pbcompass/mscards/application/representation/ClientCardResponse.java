package com.pbcompass.mscards.application.representation;

import com.pbcompass.mscards.domain.ClientCard;
import jakarta.persistence.Column;

import java.math.BigDecimal;

public class ClientCardResponse {

    private String name;
    private String flag;
    @Column(name = "card_limit")
    private BigDecimal limitReleased;

    public ClientCardResponse(){}

    public ClientCardResponse(String name, String flag, BigDecimal limitReleased) {
        this.name = name;
        this.flag = flag;
        this.limitReleased = limitReleased;
    }

    public static ClientCardResponse fromModel(ClientCard model){
        return new ClientCardResponse(
                model.getCard().getName(),
                model.getCard().getFlag().toString(),
                model.getLimit()
        );
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
