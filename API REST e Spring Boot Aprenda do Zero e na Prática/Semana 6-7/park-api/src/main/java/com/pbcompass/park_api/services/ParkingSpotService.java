package com.pbcompass.park_api.services;

import com.pbcompass.park_api.entities.ParkingSpot;
import com.pbcompass.park_api.exception.CodeUniqueViolationException;
import com.pbcompass.park_api.exception.EntityNotFoundException;
import com.pbcompass.park_api.exception.ParkingSpotAvailableException;
import com.pbcompass.park_api.repositories.ParkingSpotRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import static com.pbcompass.park_api.entities.ParkingSpot.StatusParkingSpot.AVAILABLE;

@Service
@RequiredArgsConstructor
public class ParkingSpotService {

    private final ParkingSpotRepository parkingSpotRepository;

    @Transactional
    public ParkingSpot insert(ParkingSpot parkingSpot) {
        try {
            return parkingSpotRepository.save(parkingSpot);
        } catch (DataIntegrityViolationException e) {
            throw new CodeUniqueViolationException(
                    "Parking Spot",  parkingSpot.getCode());
        }
    }

    @Transactional
    public ParkingSpot findByCode(String code) {
        return parkingSpotRepository.findByCode(code).orElseThrow(
                () -> new EntityNotFoundException("Parking Spot", code)
        );
    }

    @Transactional
    public ParkingSpot findAvailableSpot() {
        return parkingSpotRepository.findFirstByStatus(AVAILABLE).orElseThrow(
                () -> new ParkingSpotAvailableException("Available parking spot not found")
        );
    }
}
