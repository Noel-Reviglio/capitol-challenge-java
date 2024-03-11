package com.capitole.challenge.javaspringboot.noelreviglio.application.services;

import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.price.PriceCreateUseCase;
import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.price.PriceReadUseCase;

public interface PriceService extends PriceCreateUseCase, PriceReadUseCase {
}