package com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.currency;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Currency;

public interface CurrencyDeleteUseCase {

    void disabled( Currency currency, Long id );

}