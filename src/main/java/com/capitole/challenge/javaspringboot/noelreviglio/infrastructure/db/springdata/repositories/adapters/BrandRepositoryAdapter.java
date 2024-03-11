package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.repositories.adapters;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Brand;
import com.capitole.challenge.javaspringboot.noelreviglio.domain.ports.out.BrandRepositoryPort;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.mappers.BrandEntityMapper;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.repositories.BrandJPARepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BrandRepositoryAdapter implements BrandRepositoryPort {

    private final BrandJPARepository brandRepository;

    @Override
    public Optional<Brand> findById(Long id) {
        var brandEntity = this.brandRepository.findById( id );
        if( brandEntity.isEmpty() ) return Optional.empty();
        return brandEntity.map(BrandEntityMapper::toDomainModel);
    }

    @Override
    public List<Brand> findAll() {
        var brandEntities = this.brandRepository.findAll();
        return brandEntities.stream().map(BrandEntityMapper::toDomainModel).toList();
    }

    @Override
    public List<Brand> findByEnabled() {
        var brandEntities = this.brandRepository.findByEnabled( true );
        return brandEntities.stream().map(BrandEntityMapper::toDomainModel).toList();
    }

    @Override
    @Modifying
    public Brand save(Brand brand) {
        var brandEntity = BrandEntityMapper.fromDomainModel( brand );
        var savedBrandEntity = brandRepository.save( brandEntity );
        return BrandEntityMapper.toDomainModel( savedBrandEntity );
    }

    @Override
    public Brand update( Brand brand ) {
        return this.save( brand );
    }

    @Override
    public void delete( Brand brand ) {
        this.save( brand );
    }
}