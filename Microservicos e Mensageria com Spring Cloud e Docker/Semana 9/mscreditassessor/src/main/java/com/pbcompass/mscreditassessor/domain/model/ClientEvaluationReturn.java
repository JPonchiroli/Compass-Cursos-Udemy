package com.pbcompass.mscreditassessor.domain.model;

import java.util.List;

public class ClientEvaluationReturn {
    private List<CardsApproved> cards;

    public ClientEvaluationReturn(List<CardsApproved> cards) {
        this.cards = cards;
    }

    public List<CardsApproved> getCards() {
        return cards;
    }

    public void setCards(List<CardsApproved> cards) {
        this.cards = cards;
    }
}
