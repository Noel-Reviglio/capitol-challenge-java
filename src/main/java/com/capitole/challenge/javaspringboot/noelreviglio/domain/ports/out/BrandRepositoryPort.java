package com.capitole.challenge.javaspringboot.noelreviglio.domain.ports.out;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandRepositoryPort {

    Optional<Brand> findById( Long id );
    List<Brand> findAll();
    List<Brand> findByEnabled();
    Brand save( Brand brand );
    Brand update( Brand brand );
    void delete( Brand brand );
}