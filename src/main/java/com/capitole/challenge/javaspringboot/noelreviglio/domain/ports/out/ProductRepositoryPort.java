package com.capitole.challenge.javaspringboot.noelreviglio.domain.ports.out;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepositoryPort {

    Optional<Product> findById( Long id );
    List<Product> findAll();
    List<Product> findByEnabled();
    Product save( Product product);
    Product update( Product product );
    void disabled( Product product );
}