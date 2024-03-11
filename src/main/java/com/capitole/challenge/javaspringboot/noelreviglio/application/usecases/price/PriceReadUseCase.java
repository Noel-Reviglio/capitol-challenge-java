package com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.price;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceReadUseCase {

    List<Price> getByProductIdAndBrandIdAndDateBetween(Long productId, Long brandId, LocalDateTime date );
    List<Price> getAll();

}