package com.pbcompass.park_api.services;

import com.pbcompass.park_api.entities.ClientParkingSpot;
import com.pbcompass.park_api.exception.EntityNotFoundException;
import com.pbcompass.park_api.repositories.ClientParkingSpotRepository;
import com.pbcompass.park_api.repositories.projection.ClientParkingSpotProjection;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ClientParkingSpotService {

    @Autowired
    private final ClientParkingSpotRepository clientParkingSpotRepository;

    @Transactional
    public ClientParkingSpot insert(ClientParkingSpot clientParkingSpot) {
        return clientParkingSpotRepository.save(clientParkingSpot);
    }

    @Transactional
    public ClientParkingSpot findByReceipt(String receipt) {
        return clientParkingSpotRepository.findByreceiptAndExitDateIsNull(receipt).orElseThrow(
                () -> new EntityNotFoundException(
                        String.format("Receipt '%s' not found in the system or check out already done", receipt)
                )
        );
    }

    @Transactional
    public long getTotalOfTimesFullParkingLot(String cpf) {
        return clientParkingSpotRepository.countByClientCpfAndExitDateIsNotNull(cpf);
    }

    @Transactional
    public Page<ClientParkingSpotProjection> findAllByClientCpf(String cpf, Pageable pageable) {
        return clientParkingSpotRepository.findAllByClientCpf(cpf, pageable);
    }

    @Transactional
    public Page<ClientParkingSpotProjection> findAllByUserId(Long id, Pageable pageable) {
        return clientParkingSpotRepository.findAllByClientUserId(id, pageable);
    }
}
