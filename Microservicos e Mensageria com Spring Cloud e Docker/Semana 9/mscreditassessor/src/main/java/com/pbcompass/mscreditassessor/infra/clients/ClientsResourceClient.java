package com.pbcompass.mscreditassessor.infra.clients;

import com.pbcompass.mscreditassessor.domain.model.ClientData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "msclients", path = "/clients")
public interface ClientsResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<ClientData> clientData(@RequestParam("cpf") String cpf);

}
