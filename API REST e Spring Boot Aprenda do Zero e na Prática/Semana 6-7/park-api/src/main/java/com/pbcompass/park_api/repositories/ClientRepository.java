package com.pbcompass.park_api.repositories;

import com.pbcompass.park_api.entities.Client;
import com.pbcompass.park_api.repositories.projection.ClientProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select c from Client c ")
    Page<ClientProjection> findAllPageable(Pageable pageable);

    Client findByUserId(Long id);

    Optional<Client> findByCpf(String cpf);
}
