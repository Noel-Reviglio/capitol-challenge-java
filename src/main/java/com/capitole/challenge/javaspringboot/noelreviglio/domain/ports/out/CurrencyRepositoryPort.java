package com.capitole.challenge.javaspringboot.noelreviglio.domain.ports.out;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Currency;

import java.util.List;
import java.util.Optional;

public interface CurrencyRepositoryPort {

    Optional<Currency> findByCode( String code );
    List<Currency> findAll();
    List<Currency> findByEnabled();
    Currency save(Currency currency);
    void disabled( Currency currency );
}