package com.pbcompass.park_api.services;

import com.pbcompass.park_api.entities.ParkingSpot;
import com.pbcompass.park_api.exception.CodeUniqueViolationException;
import com.pbcompass.park_api.exception.EntityNotFoundException;
import com.pbcompass.park_api.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParkingSpotService {

    private final ParkingSpotRepository parkingSpotRepository;

    @Transactional
    public ParkingSpot insert(ParkingSpot parkingSpot) {
        try {
            return parkingSpotRepository.save(parkingSpot);
        } catch (DataIntegrityViolationException e) {
            throw new CodeUniqueViolationException(String.format(
                    "Parking Spot with code '%s' already registered", parkingSpot.getCode()));
        }
    }

    @Transactional
    public ParkingSpot findById(String code) {
        return parkingSpotRepository.findByCode(code).orElseThrow(
                () -> new EntityNotFoundException(String.format("Parking Spot with the code '%s' not found", code))
        );
    }

}
