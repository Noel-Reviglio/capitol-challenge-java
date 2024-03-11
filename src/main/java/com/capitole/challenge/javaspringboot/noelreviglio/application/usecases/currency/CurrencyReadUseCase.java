package com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.currency;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Currency;

import java.util.List;
import java.util.Optional;

public interface CurrencyReadUseCase {

    Optional<Currency> getByCode( String code );
    List<Currency> getAll();
    List<Currency> getByEnabled();

}