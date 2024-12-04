package com.pbcompass.msclients.services;

import com.pbcompass.msclients.entities.Client;
import com.pbcompass.msclients.repositories.ClientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    @Autowired
    private final ClientRepository repository;

    @Transactional
    public Client save(Client client){
        return repository.save(client);
    }

    public Optional<Client> getByCPF(String cpf){
        return repository.findByCpf(cpf);
    }

}
