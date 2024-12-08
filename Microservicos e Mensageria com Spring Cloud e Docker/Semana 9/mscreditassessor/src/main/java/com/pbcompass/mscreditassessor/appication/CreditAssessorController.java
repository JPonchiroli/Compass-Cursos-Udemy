package com.pbcompass.mscreditassessor.appication;

import com.pbcompass.mscreditassessor.appication.ex.ClientDataNotFoundException;
import com.pbcompass.mscreditassessor.appication.ex.CommunicationErrorMicroservicesException;
import com.pbcompass.mscreditassessor.domain.model.StatusClient;
import org.springframework.http.HttpStatus;
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
}
