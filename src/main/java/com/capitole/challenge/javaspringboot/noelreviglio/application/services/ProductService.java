package com.capitole.challenge.javaspringboot.noelreviglio.application.services;

import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.product.ProductCreateUseCase;
import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.product.ProductDeleteUseCase;
import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.product.ProductReadUseCase;
import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.product.ProductUpdateUseCase;

public interface ProductService extends ProductCreateUseCase, ProductReadUseCase, ProductUpdateUseCase, ProductDeleteUseCase {
}