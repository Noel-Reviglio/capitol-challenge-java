package com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.product;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Product;

public interface ProductUpdateUseCase {

    Product update( Product product, Long id );

}