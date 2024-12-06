package com.pbcompass.mscards.application;

import com.pbcompass.mscards.application.representation.CardSaveRequest;
import com.pbcompass.mscards.application.representation.ClientCardResponse;
import com.pbcompass.mscards.domain.Card;
import com.pbcompass.mscards.domain.ClientCard;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cards")
public class CardsResource {

    private final CardsService service;
    private final ClientCardService clientCardService;

    public CardsResource(CardsService service, ClientCardService clientCardService) {
        this.service = service;
        this.clientCardService = clientCardService;
    }

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity register(@RequestBody CardSaveRequest request){
        Card card = request.toModel();
        service.save(card);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "income")
    public ResponseEntity<List<Card>> getCardsWithIncomeUntil(@RequestParam("income") Long income){
        List<Card> cards = service.getCardsIncomeLessEqual(income);
        return ResponseEntity.ok(cards);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<ClientCardResponse>> getCardsByClient(@RequestParam("cpf") String cpf){
        List<ClientCard> list = clientCardService.findByCpf(cpf);
        List<ClientCardResponse> resultList = list.stream()
                .map(ClientCardResponse::fromModel)
                .toList();
        return ResponseEntity.ok(resultList);
    }


}
