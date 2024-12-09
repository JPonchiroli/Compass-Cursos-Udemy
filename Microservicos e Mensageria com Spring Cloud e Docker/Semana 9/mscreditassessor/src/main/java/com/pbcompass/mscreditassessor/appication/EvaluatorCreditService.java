package com.pbcompass.mscreditassessor.appication;

import com.pbcompass.mscreditassessor.appication.ex.ClientDataNotFoundException;
import com.pbcompass.mscreditassessor.appication.ex.CommunicationErrorMicroservicesException;
import com.pbcompass.mscreditassessor.appication.ex.SolicitationErrorException;
import com.pbcompass.mscreditassessor.domain.model.*;
import com.pbcompass.mscreditassessor.infra.clients.CardsResourceClient;
import com.pbcompass.mscreditassessor.infra.clients.ClientsResourceClient;
import com.pbcompass.mscreditassessor.infra.clients.mqueue.SolicitationEmissionCardPublisher;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class EvaluatorCreditService {

    private final ClientsResourceClient clientsClient;
    private final CardsResourceClient cardsClient;
    private final SolicitationEmissionCardPublisher emissionCardPublisher;

    public EvaluatorCreditService(ClientsResourceClient clientsClient, CardsResourceClient cardsClient, SolicitationEmissionCardPublisher emissionCardPublisher) {
        this.clientsClient = clientsClient;
        this.cardsClient = cardsClient;
        this.emissionCardPublisher = emissionCardPublisher;
    }

    public StatusClient getStatusClient(String cpf) throws ClientDataNotFoundException, CommunicationErrorMicroservicesException {
        try {
            ResponseEntity<ClientData> clientDataResponse = clientsClient.clientData(cpf);
            ResponseEntity<List<ClientCard>> cardsDataResponse = cardsClient.getCardsByClient(cpf);

            StatusClient.Builder builder = StatusClient.builder();
            builder.client(clientDataResponse.getBody());
            builder.cards(cardsDataResponse.getBody());

            return builder.build();
        } catch (FeignException.FeignClientException e) {
            int status = e.status();
            if (HttpStatus.NOT_FOUND.value() == status) {
                throw new ClientDataNotFoundException();
            }
            throw new CommunicationErrorMicroservicesException(e.getMessage(), status);
        }
    }

    public ClientEvaluationReturn doEvaluation(String cpf, Long income) throws ClientDataNotFoundException, CommunicationErrorMicroservicesException {
        try {
            ResponseEntity<ClientData> clientDataResponse = clientsClient.clientData(cpf);
            ResponseEntity<List<Card>> cardsResponse = cardsClient.getCardsWithIncomeUntil(income);

            List<Card> cards = cardsResponse.getBody();
            List<CardsApproved> cardsApprovedList = cards.stream().map(card -> {

                ClientData clientData = clientDataResponse.getBody();

                BigDecimal basicLimit = card.getBasicLimit();
                BigDecimal ageBD = BigDecimal.valueOf(clientData.getAge());
                BigDecimal factor = ageBD.divide(BigDecimal.valueOf(10));
                BigDecimal approvedLimit = factor.multiply(basicLimit);

                CardsApproved approved = new CardsApproved();
                approved.setCard(card.getName());
                approved.setFlag(card.getFlag());
                approved.setApprovedLimit(approvedLimit);

                return approved;
            }).toList();

            return new ClientEvaluationReturn(cardsApprovedList);


        } catch (FeignException.FeignClientException e) {
            int status = e.status();
            if (HttpStatus.NOT_FOUND.value() == status) {
                throw new ClientDataNotFoundException();
            }
            throw new CommunicationErrorMicroservicesException(e.getMessage(), status);
        }
    }

    public SolicitationProtocolCard requestEmissionCard(DataSolicitationEmissionCard data){
        try {
            emissionCardPublisher.requestCard(data);
            String protocol = UUID.randomUUID().toString();
            return new SolicitationProtocolCard(protocol);
        } catch (Exception e) {
            throw new SolicitationErrorException(e.getMessage());
        }

    }
}
