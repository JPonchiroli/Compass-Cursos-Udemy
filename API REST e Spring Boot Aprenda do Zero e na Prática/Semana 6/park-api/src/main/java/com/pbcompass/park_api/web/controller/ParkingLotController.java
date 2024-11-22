package com.pbcompass.park_api.web.controller;

import com.pbcompass.park_api.entities.ClientParkingSpot;
import com.pbcompass.park_api.services.ParkingLotService;
import com.pbcompass.park_api.web.dto.ParkingLotCreateDto;
import com.pbcompass.park_api.web.dto.ParkingLotResponseDto;
import com.pbcompass.park_api.web.dto.mapper.ClientParkingSpotMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/parkingLots")
public class ParkingLotController {

    @Autowired
    private final ParkingLotService parkingLotService;

    @PostMapping("/checkIn")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ParkingLotResponseDto> checkIn(@RequestBody @Valid ParkingLotCreateDto dto) {
        ClientParkingSpot clientParkingSpot = ClientParkingSpotMapper.toClientParkingSpot(dto);
        parkingLotService.checkIn(clientParkingSpot);
        ParkingLotResponseDto responseDto = ClientParkingSpotMapper.toDto(clientParkingSpot);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri().path("/{receipt}")
                .buildAndExpand(clientParkingSpot.getReceipt())
                .toUri();
        return ResponseEntity.created(location).body(responseDto);
    }
}
