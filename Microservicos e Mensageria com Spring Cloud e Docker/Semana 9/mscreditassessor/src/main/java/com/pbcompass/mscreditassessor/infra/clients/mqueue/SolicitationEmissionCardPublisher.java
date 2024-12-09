package com.pbcompass.mscreditassessor.infra.clients.mqueue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pbcompass.mscreditassessor.domain.model.DataSolicitationEmissionCard;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class SolicitationEmissionCardPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final Queue queueEmissionCard;

    public SolicitationEmissionCardPublisher(RabbitTemplate rabbitTemplate, Queue queueEmissionCard) {
        this.rabbitTemplate = rabbitTemplate;
        this.queueEmissionCard = queueEmissionCard;
    }

    public void requestCard(DataSolicitationEmissionCard data) throws JsonProcessingException {
        String json = convertIntoJson(data);
        rabbitTemplate.convertAndSend(queueEmissionCard.getName(), json);
    }

    private String convertIntoJson(DataSolicitationEmissionCard data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(data);
    }
}
