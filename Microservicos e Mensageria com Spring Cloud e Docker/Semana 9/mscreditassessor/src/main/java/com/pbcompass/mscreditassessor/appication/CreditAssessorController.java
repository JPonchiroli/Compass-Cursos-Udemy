package com.pbcompass.mscreditassessor.appication;

import com.pbcompass.mscreditassessor.domain.model.StatusClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit-evaluation")
public class CreditAssessorController {

    private final EvaluatorCreditService service;

    public CreditAssessorController(EvaluatorCreditService service) {
        this.service = service;
    }

    @GetMapping
    public String status(){
        return "ok";
    }

    @GetMapping(value = "status-client", params = "cpf")
    public ResponseEntity<StatusClient> checkStatusClient(@RequestParam("cpf") String cpf){
        StatusClient statusClient = service.getStatusClient(cpf);
        return ResponseEntity.ok(statusClient);
    }
}
