package com.pbcompass.mscreditassessor.appication;

import com.pbcompass.mscreditassessor.appication.ex.ClientDataNotFoundException;
import com.pbcompass.mscreditassessor.appication.ex.CommunicationErrorMicroservicesException;
import com.pbcompass.mscreditassessor.domain.model.ClientCard;
import com.pbcompass.mscreditassessor.domain.model.ClientData;
import com.pbcompass.mscreditassessor.domain.model.StatusClient;
import com.pbcompass.mscreditassessor.infra.clients.CardsResourceClient;
import com.pbcompass.mscreditassessor.infra.clients.ClientsResourceClient;
import feign.FeignException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluatorCreditService {

    private final ClientsResourceClient clientsClient;
    private final CardsResourceClient cardsClient;

    public EvaluatorCreditService(ClientsResourceClient clientsClient, CardsResourceClient cardsClient) {
        this.clientsClient = clientsClient;
        this.cardsClient = cardsClient;
    }

    public StatusClient getStatusClient(String cpf) throws ClientDataNotFoundException, CommunicationErrorMicroservicesException{
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
}
