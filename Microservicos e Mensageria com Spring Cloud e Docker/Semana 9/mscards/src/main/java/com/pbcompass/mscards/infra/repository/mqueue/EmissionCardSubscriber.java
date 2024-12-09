package com.pbcompass.mscards.infra.repository.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pbcompass.mscards.domain.Card;
import com.pbcompass.mscards.domain.ClientCard;
import com.pbcompass.mscards.domain.DataSolicitationEmissionCard;
import com.pbcompass.mscards.infra.repository.CardsRepository;
import com.pbcompass.mscards.infra.repository.ClientCardRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmissionCardSubscriber {

    private final CardsRepository cardsRepository;
    private final ClientCardRepository clientCardRepository;

    public EmissionCardSubscriber(CardsRepository cardsRepository, ClientCardRepository clientCardRepository) {
        this.cardsRepository = cardsRepository;
        this.clientCardRepository = clientCardRepository;
    }

    @RabbitListener(queues = "${mq.queues.emission-card}")
    public void receiptEmissionSolicitation(@Payload String payload){
        try {
            ObjectMapper mapper = new ObjectMapper();
            DataSolicitationEmissionCard data = mapper.readValue(payload, DataSolicitationEmissionCard.class);
            Card card = cardsRepository.findById(data.getIdCard()).orElseThrow();

            ClientCard clientCard = new ClientCard();
            clientCard.setCard(card);
            clientCard.setCpf(data.getCpf());
            clientCard.setLimit(data.getApprovedLimit());

            clientCardRepository.save(clientCard);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
