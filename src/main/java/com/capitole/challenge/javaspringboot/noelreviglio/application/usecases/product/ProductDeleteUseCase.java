package com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.product;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Product;

public interface ProductDeleteUseCase {

    void disabled( Product product, Long id );

}