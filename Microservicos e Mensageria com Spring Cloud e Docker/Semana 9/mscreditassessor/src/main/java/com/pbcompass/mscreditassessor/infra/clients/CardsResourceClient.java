package com.pbcompass.mscreditassessor.infra.clients;

import com.pbcompass.mscreditassessor.domain.model.ClientCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "mscards", path = "cards")
public interface CardsResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<List<ClientCard>> getCardsByClient(@RequestParam("cpf") String cpf);
}
