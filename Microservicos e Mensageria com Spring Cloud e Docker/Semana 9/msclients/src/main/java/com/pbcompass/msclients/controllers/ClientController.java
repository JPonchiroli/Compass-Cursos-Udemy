package com.pbcompass.msclients.controllers;

import jakarta.persistence.Column;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @GetMapping
    public String status(){
        return "ok";
    }
}
