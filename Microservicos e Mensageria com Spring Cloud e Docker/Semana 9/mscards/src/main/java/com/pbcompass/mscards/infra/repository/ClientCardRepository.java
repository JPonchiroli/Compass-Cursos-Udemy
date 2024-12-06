package com.pbcompass.mscards.infra.repository;

import com.pbcompass.mscards.domain.ClientCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientCardRepository extends JpaRepository<ClientCard, Long> {
    List<ClientCard> findByCpf(String cpf);
}
