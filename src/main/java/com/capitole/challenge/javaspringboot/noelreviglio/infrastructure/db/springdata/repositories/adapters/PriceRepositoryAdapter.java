package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.repositories.adapters;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Price;
import com.capitole.challenge.javaspringboot.noelreviglio.domain.ports.out.PriceRepositoryPort;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.mappers.PriceEntityMapper;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.repositories.PriceJPARepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class PriceRepositoryAdapter implements PriceRepositoryPort {

    private final PriceJPARepository priceRepository;

    @Override
    public List<Price> findByProductIdAndBrandIdAndDateBetween(Long productId, Long brandId, LocalDateTime date, Object pageable) {
        var priceEntities = this.priceRepository.findByProductIdAndBrandIdAndDateBetween( productId, brandId, date, (Pageable) pageable );
        return priceEntities.stream().map( PriceEntityMapper::toDomainModel ).toList();
    }

    @Override
    public List<Price> findAll() {
        var priceEntities = this.priceRepository.findAll();
        return priceEntities.stream().map( PriceEntityMapper::toDomainModel ).toList();
    }

    @Override
    @Modifying
    public Price save( Price price ) {
        var priceEntity = PriceEntityMapper.fromDomainModel( price );
        var savedPriceEntity = priceRepository.save( priceEntity );
        return PriceEntityMapper.toDomainModel( savedPriceEntity );
    }

    @Override
    public List<Price> saveAll( List<Price> prices ) {
        var priceEntities = prices.stream().map(PriceEntityMapper::fromDomainModel).toList();
        var savedPriceEntities = priceRepository.saveAll( priceEntities );
        return savedPriceEntities.stream().map( PriceEntityMapper::toDomainModel ).toList();
    }
}