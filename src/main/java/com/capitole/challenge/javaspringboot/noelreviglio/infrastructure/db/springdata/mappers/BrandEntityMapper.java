package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.mappers;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Brand;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.entities.BrandEntity;

public class BrandEntityMapper {

    private BrandEntityMapper(){}
    public static BrandEntity fromDomainModel(Brand brand){
        return new BrandEntity( brand.getId(), brand.getName(), brand.isEnabled() );
    }

    public static Brand toDomainModel( BrandEntity brandEntity){
        return new Brand(brandEntity.getId(), brandEntity.getName(), brandEntity.isEnabled() );
    }
}