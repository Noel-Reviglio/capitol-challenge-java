package com.capitole.challenge.javaspringboot.noelreviglio.application.services;

import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.brand.BrandCreateUseCase;
import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.brand.BrandDeleteUseCase;
import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.brand.BrandReadUseCase;
import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.brand.BrandUpdateUseCase;

public interface BrandService extends BrandCreateUseCase, BrandReadUseCase, BrandUpdateUseCase, BrandDeleteUseCase {
}