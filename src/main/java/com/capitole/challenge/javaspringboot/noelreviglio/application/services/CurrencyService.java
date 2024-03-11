package com.capitole.challenge.javaspringboot.noelreviglio.application.services;

import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.currency.CurrencyCreateUseCase;
import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.currency.CurrencyDeleteUseCase;
import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.currency.CurrencyReadUseCase;

public interface CurrencyService extends CurrencyCreateUseCase, CurrencyReadUseCase, CurrencyDeleteUseCase {
}