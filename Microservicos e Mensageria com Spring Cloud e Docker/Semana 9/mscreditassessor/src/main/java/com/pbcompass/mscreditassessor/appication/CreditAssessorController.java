package com.pbcompass.mscreditassessor.appication;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/credit-evaluation")
public class CreditAssessorController {

    @GetMapping
    public String status(){
        return "ok";
    }
}
