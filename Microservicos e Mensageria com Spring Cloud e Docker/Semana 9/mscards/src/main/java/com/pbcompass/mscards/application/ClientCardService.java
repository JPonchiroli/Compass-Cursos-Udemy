package com.pbcompass.mscards.application;

import com.pbcompass.mscards.domain.ClientCard;
import com.pbcompass.mscards.infra.repository.ClientCardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientCardService {

    private final ClientCardRepository repository;

    public ClientCardService(ClientCardRepository repository) {
        this.repository = repository;
    }

    public List<ClientCard> findByCpf(String cpf){
        return repository.findByCpf(cpf);
    }

}
