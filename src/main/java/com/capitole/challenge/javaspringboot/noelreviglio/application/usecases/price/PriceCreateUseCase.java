package com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.price;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Price;

import java.util.List;

public interface PriceCreateUseCase {

    Price save(Price price);
    List<Price> saveAll(List<Price> prices);

}