package com.pbcompass.park_api.web.controller;

import com.pbcompass.park_api.entities.ParkingSpot;
import com.pbcompass.park_api.services.ParkingSpotService;
import com.pbcompass.park_api.web.dto.ParkingSpotCreateDto;
import com.pbcompass.park_api.web.dto.ParkingSpotResponseDto;
import com.pbcompass.park_api.web.dto.mapper.ParkingSpotMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/parkingSpot")
public class ParkingSpotController {

    private final ParkingSpotService parkingSpotService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> insert(@RequestBody @Valid ParkingSpotCreateDto dto) {
        ParkingSpot parkingSpot = ParkingSpotMapper.toParkingSpot(dto);
        parkingSpotService.insert(parkingSpot);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri().path("/{code}")
                .buildAndExpand(parkingSpot.getCode())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{code}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ParkingSpotResponseDto> findByCode(@PathVariable String code) {
        ParkingSpot parkingSpot = parkingSpotService.findByCode(code);
        return ResponseEntity.ok(ParkingSpotMapper.toDto(parkingSpot));
    }

}
