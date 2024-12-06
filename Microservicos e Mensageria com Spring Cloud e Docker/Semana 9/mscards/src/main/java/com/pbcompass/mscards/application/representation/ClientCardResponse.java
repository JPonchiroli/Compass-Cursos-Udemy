package com.pbcompass.mscards.application.representation;

import com.pbcompass.mscards.domain.ClientCard;

import java.math.BigDecimal;

public class ClientCardResponse {

    private String name;
    private String flag;
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
}
