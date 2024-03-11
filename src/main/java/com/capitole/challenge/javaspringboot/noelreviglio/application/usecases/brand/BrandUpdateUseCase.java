package com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.brand;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Brand;

public interface BrandUpdateUseCase {

    Brand update( Brand brand, Long id );

}