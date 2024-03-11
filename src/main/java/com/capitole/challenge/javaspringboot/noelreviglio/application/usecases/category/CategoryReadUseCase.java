package com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.category;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryReadUseCase {

    Optional<Category> getById( Long id );
    List<Category> getAll();

}