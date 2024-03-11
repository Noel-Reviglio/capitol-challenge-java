package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.mappers;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Currency;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.entities.CurrencyEntity;

public class CurrencyEntityMapper {

    private CurrencyEntityMapper(){}
    public static CurrencyEntity fromDomainModel(Currency currency){
        return new CurrencyEntity( currency.getCode(), currency.getName(), currency.isEnabled() );
    }

    public static Currency toDomainModel( CurrencyEntity currencyEntity){
        return new Currency(currencyEntity.getCode(), currencyEntity.getName(), currencyEntity.isEnabled() );
    }
}