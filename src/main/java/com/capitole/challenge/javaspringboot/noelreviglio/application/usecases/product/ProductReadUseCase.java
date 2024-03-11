package com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.product;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductReadUseCase {

    Optional<Product> getById(Long id );
    List<Product> getAll();
    List<Product> getByEnabled();

}