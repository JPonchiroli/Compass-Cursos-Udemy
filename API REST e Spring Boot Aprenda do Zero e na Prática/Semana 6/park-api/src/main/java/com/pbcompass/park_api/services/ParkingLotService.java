package com.pbcompass.park_api.services;

import com.pbcompass.park_api.entities.ParkingSpot;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ParkingLotService {

    @Autowired
    private final ClientParkingSpotService clientParkingSpotService;

    @Autowired
    private final ClientService clientService;

    @Autowired
    private final ParkingSpotService parkingSpotService;
}
