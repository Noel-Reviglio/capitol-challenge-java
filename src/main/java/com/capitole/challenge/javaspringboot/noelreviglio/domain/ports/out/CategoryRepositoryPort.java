package com.capitole.challenge.javaspringboot.noelreviglio.domain.ports.out;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepositoryPort {

    Optional<Category> findById( Long id );
    List<Category> findAll();
    Category save( Category category );
    Category update( Category category, Long id );
    void delete( Long id );
}