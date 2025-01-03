package com.pbcompass.park_api.services;

import com.pbcompass.park_api.entities.Client;
import com.pbcompass.park_api.exception.CpfUniqueViolationException;
import com.pbcompass.park_api.exception.EntityNotFoundException;
import com.pbcompass.park_api.repositories.ClientRepository;
import com.pbcompass.park_api.repositories.projection.ClientProjection;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;

@RequiredArgsConstructor
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Transactional
    public Client insert(Client client) {
        try {
            return clientRepository.save(client);
        } catch (DataIntegrityViolationException e) {
            throw new CpfUniqueViolationException(
                    String.format("CPF '%s' already registered.", client.getCpf()));
        }
    }

    @Transactional
    public Client findById(Long id) {
        return clientRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Client id={} not found in the system", id))
        );
    }

    @Transactional
    public Page<ClientProjection> findAll(Pageable pageble) {
        return clientRepository.findAllPageable(pageble);
    }

    @Transactional
    public Client findByUserId(Long id) {
        return clientRepository.findByUserId(id);
    }

    @Transactional
    public Client findByCpf(String cpf) {
        return clientRepository.findByCpf(cpf).orElseThrow(
                () -> new EntityNotFoundException(String.format("Client with cpf={%s} not found", cpf))
        );
    }
}
