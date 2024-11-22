package com.pbcompass.park_api.repositories;

import com.pbcompass.park_api.entities.ParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingSpotRepository extends JpaRepository<ParkingSpot, Long> {
}
