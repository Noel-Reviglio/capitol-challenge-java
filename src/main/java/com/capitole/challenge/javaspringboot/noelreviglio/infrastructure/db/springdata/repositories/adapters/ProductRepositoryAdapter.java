package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.repositories.adapters;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Product;
import com.capitole.challenge.javaspringboot.noelreviglio.domain.ports.out.ProductRepositoryPort;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.mappers.ProductEntityMapper;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.repositories.ProductJPARepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    private final ProductJPARepository productRepository;

    @Override
    public Optional<Product> findById( Long id ) {
        var productEntity = this.productRepository.findById( id );
        if( productEntity.isEmpty() ) return Optional.empty();
        return productEntity.map( ProductEntityMapper::toDomainModel );
    }

    @Override
    public List<Product> findAll() {
        var productEntities = this.productRepository.findAll();
        return productEntities.stream().map(ProductEntityMapper::toDomainModel).toList();
    }

    @Override
    public List<Product> findByEnabled() {
        var productEntities = this.productRepository.findByEnabled( true );
        return productEntities.stream().map(ProductEntityMapper::toDomainModel).toList();
    }

    @Override
    @Modifying
    public Product save( Product product ) {
        var productEntity = ProductEntityMapper.fromDomainModel(product);
        var savedProductEntity = productRepository.save(productEntity);
        return ProductEntityMapper.toDomainModel(savedProductEntity);
    }

    @Override
    public Product update( Product product ) {
        return this.save( product );
    }

    @Override
    public void disabled( Product product ) {
        this.save( product );
    }
}