package com.capitole.challenge.javaspringboot.noelreviglio.domain.ports.out;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Price;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PriceRepositoryPort {

    Optional<Price> findByDateBetweenAndProductIdAndBrandId( LocalDateTime date, Long productId, Long brandId );
    List<Price> findAll();
    Price save(Price price);
}