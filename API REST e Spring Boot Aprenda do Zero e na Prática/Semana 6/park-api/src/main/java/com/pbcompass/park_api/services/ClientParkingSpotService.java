package com.pbcompass.park_api.services;

import com.pbcompass.park_api.entities.ClientParkingSpot;
import com.pbcompass.park_api.repositories.ClientParkingSpotRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

}
