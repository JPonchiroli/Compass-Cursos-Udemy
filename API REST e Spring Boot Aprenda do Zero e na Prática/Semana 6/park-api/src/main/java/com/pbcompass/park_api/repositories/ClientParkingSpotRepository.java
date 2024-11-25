package com.pbcompass.park_api.repositories;

import com.pbcompass.park_api.entities.ClientParkingSpot;
import com.pbcompass.park_api.repositories.projection.ClientParkingSpotProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientParkingSpotRepository extends JpaRepository<ClientParkingSpot, Long> {
    Optional<ClientParkingSpot> findByreceiptAndExitDateIsNull(String receipt);

    long countByClientCpfAndExitDateIsNotNull(String cpf);

    Page<ClientParkingSpotProjection> findAllByClientCpf(String cpf, Pageable pageable);

    Page<ClientParkingSpotProjection> findAllByClientUserId(Long id, Pageable pageable);
}
