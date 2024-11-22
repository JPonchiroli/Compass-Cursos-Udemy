package com.pbcompass.park_api.services;

import com.pbcompass.park_api.entities.Client;
import com.pbcompass.park_api.entities.ClientParkingSpot;
import com.pbcompass.park_api.entities.ParkingSpot;
import com.pbcompass.park_api.utils.ParkingLotUtils;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

import static com.pbcompass.park_api.entities.ParkingSpot.StatusParkingSpot.OCCUPIED;

@RequiredArgsConstructor
@Service
public class ParkingLotService {

    @Autowired
    private final ClientParkingSpotService clientParkingSpotService;

    @Autowired
    private final ClientService clientService;

    @Autowired
    private final ParkingSpotService parkingSpotService;

    @Transactional
    public ClientParkingSpot checkIn(ClientParkingSpot clientParkingSpot) {
        Client client = clientService.findByCpf(clientParkingSpot.getClient().getCpf());
        clientParkingSpot.setClient(client);

        ParkingSpot parkingSpot = parkingSpotService.findAvailableSpot();
        parkingSpot.setStatus(OCCUPIED);
        clientParkingSpot.setParkingSpot(parkingSpot);

        clientParkingSpot.setEntryDate(LocalDateTime.now());
        clientParkingSpot.setReceipt(ParkingLotUtils.generateReceipt());

        return clientParkingSpotService.insert(clientParkingSpot);
    }
}
