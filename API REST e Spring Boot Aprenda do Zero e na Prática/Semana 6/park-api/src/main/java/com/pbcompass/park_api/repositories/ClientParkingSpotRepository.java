package com.pbcompass.park_api.repositories;

import com.pbcompass.park_api.entities.ClientParkingSpot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientParkingSpotRepository extends JpaRepository<ClientParkingSpot, Long> {
}
