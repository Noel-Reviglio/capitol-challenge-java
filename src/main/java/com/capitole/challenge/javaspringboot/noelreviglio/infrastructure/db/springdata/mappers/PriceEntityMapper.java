package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.mappers;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Price;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.entities.PriceEntity;

public class PriceEntityMapper {

    private PriceEntityMapper(){}
    public static PriceEntity fromDomainModel( Price price ){
        return new PriceEntity( price.getId(), BrandEntityMapper.fromDomainModel( price.getBrand()), price.getStartDate(),
                                price.getEndDate(), price.getPriceList(), ProductEntityMapper.fromDomainModel( price.getProduct() ),
                                price.getPriority(), price.getFinalPrice(), CurrencyEntityMapper.fromDomainModel( price.getCurrency() ));
    }

    public static Price toDomainModel( PriceEntity priceEntity ){
        return new Price( priceEntity.getId(), BrandEntityMapper.toDomainModel( priceEntity.getBrand() ),
                            priceEntity.getStartDate(), priceEntity.getEndDate(), priceEntity.getPriceList(),
                            ProductEntityMapper.toDomainModel( priceEntity.getProduct() ), priceEntity.getPriority(),
                            priceEntity.getFinalPrice(), CurrencyEntityMapper.toDomainModel( priceEntity.getCurrency() ));
    }
}