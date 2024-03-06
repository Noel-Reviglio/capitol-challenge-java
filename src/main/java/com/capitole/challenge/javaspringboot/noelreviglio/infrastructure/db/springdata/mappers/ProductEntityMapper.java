package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.mappers;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Product;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.entities.ProductEntity;

public class ProductEntityMapper {

    private ProductEntityMapper(){}
    public static ProductEntity fromDomainModel(Product product){
        return new ProductEntity( product.getId(), product.getName(), product.getDescription(),
                                    CategoryEntityMapper.fromDomainModel( product.getCategory() ), product.isEnabled() );
    }

    public static Product toDomainModel( ProductEntity productEntity){
        return new Product(productEntity.getId(), productEntity.getName(), productEntity.getDescription(),
                            CategoryEntityMapper.toDomainModel( productEntity.getCategory() ), productEntity.isEnabled() );
    }
}