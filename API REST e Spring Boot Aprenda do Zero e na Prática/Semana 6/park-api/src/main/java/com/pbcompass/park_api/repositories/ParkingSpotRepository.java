package com.pbcompass.park_api.repositories;

import com.pbcompass.park_api.entities.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {
    Optional<ParkingSpot> findByCode(String code);

    Optional<ParkingSpot> findFirstByStatus(ParkingSpot.StatusParkingSpot statusParkingSpot);
}
