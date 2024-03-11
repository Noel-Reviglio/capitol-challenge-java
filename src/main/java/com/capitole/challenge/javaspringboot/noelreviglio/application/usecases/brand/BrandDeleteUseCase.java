package com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.brand;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Brand;

public interface BrandDeleteUseCase {

    void delete( Brand brand, Long id );
}