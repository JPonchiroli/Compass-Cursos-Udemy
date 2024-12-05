package com.pbcompass.msclients.application;

import com.pbcompass.msclients.domain.Client;
import com.pbcompass.msclients.infra.repository.ClientRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Client save(Client client){
        return repository.save(client);
    }

    public Optional<Client> getByCPF(String cpf){
        return repository.findByCpf(cpf);
    }

}
