package com.pbcompass.mscreditassessor.appication;

import com.pbcompass.mscreditassessor.appication.ex.ClientDataNotFoundException;
import com.pbcompass.mscreditassessor.appication.ex.CommunicationErrorMicroservicesException;
import com.pbcompass.mscreditassessor.appication.ex.SolicitationErrorException;
import com.pbcompass.mscreditassessor.domain.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity checkStatusClient(@RequestParam("cpf") String cpf){
        try {
            StatusClient statusClient = service.getStatusClient(cpf);
            return ResponseEntity.ok(statusClient);
        } catch (ClientDataNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (CommunicationErrorMicroservicesException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity doEvaluation(@RequestBody DataEvaluation data){
        try {
            ClientEvaluationReturn clientEvaluationReturn = service.doEvaluation(data.getCpf(), data.getIncome());
            return ResponseEntity.ok(clientEvaluationReturn);
        } catch (ClientDataNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (CommunicationErrorMicroservicesException e) {
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }

    @PostMapping("solicitation-card")
    public ResponseEntity requestCard(@RequestBody DataSolicitationEmissionCard data){
        try {
            SolicitationProtocolCard protocolCard = service.requestEmissionCard(data);
            return ResponseEntity.ok(protocolCard);
        } catch (SolicitationErrorException e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
