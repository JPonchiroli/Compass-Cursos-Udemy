package com.pbcompass.mscards.application;

import com.pbcompass.mscards.domain.Cards;
import com.pbcompass.mscards.infra.repository.CardsRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CardsService {

    private final CardsRepository repository;

    public CardsService(CardsRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Cards save(Cards card){
        return repository.save(card);
    }

    public List<Cards> getCardsIncomeLessEqual(Long income){
        BigDecimal incomeBigDecimal = BigDecimal.valueOf(income);
        return repository.findByIncomeLessThanEqual(incomeBigDecimal);
    }
}
