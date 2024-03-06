package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.repositories.adapters;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Currency;
import com.capitole.challenge.javaspringboot.noelreviglio.domain.ports.out.CurrencyRepositoryPort;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.mappers.CurrencyEntityMapper;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.repositories.CurrencyJPARepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CurrencyRepositoryAdapter implements CurrencyRepositoryPort {

    private final CurrencyJPARepository currencyRepository;

    @Override
    public Optional<Currency> findByCode( String code ) {
        var currencyEntity = this.currencyRepository.findByCode( code );
        if( currencyEntity.isEmpty() ) return Optional.empty();
        return currencyEntity.map(CurrencyEntityMapper::toDomainModel);
    }

    @Override
    public List<Currency> findAll() {
        var currencyEntity = this.currencyRepository.findAll();
        return currencyEntity.stream().map(CurrencyEntityMapper::toDomainModel).toList();
    }

    @Override
    public List<Currency> findByEnabled() {
        var currencyEntity = this.currencyRepository.findByEnabled( true );
        return currencyEntity.stream().map(CurrencyEntityMapper::toDomainModel).toList();
    }

    @Override
    @Modifying
    public Currency save( Currency currency ) {
        var currencyEntity = CurrencyEntityMapper.fromDomainModel(currency);
        var savedCurrencyEntity = currencyRepository.save(currencyEntity);
        return CurrencyEntityMapper.toDomainModel(savedCurrencyEntity);
    }

    @Override
    public void disabled( Currency currency ) {
        this.save( currency );
    }

}