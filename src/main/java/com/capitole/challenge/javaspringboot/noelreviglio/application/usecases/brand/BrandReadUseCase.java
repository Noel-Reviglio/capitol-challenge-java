package com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.brand;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Brand;

import java.util.List;
import java.util.Optional;

public interface BrandReadUseCase {

    Optional<Brand> getById(Long id );
    List<Brand> getAll();
    List<Brand> getByEnabled();
}