package com.pbcompass.mscreditassessor.domain.model;

import java.util.List;

public class StatusClient {

    private ClientData client;
    private List<ClientCard> cards;

    public StatusClient(){}

    public StatusClient(ClientData client, List<ClientCard> cards) {
        this.client = client;
        this.cards = cards;
    }

    public ClientData getClient() {
        return client;
    }

    public void setClient(ClientData client) {
        this.client = client;
    }

    public List<ClientCard> getCards() {
        return cards;
    }

    public void setCards(List<ClientCard> cards) {
        this.cards = cards;
    }
}
