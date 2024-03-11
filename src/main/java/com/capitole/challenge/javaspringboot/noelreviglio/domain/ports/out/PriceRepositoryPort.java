package com.capitole.challenge.javaspringboot.noelreviglio.domain.ports.out;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceRepositoryPort {

    List<Price> findByProductIdAndBrandIdAndDateBetween( Long productId, Long brandId, LocalDateTime date, Object pageable );
    List<Price> findAll();
    Price save(Price price);
    List<Price> saveAll(List<Price> prices);
}