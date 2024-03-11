package com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.category;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Category;

public interface CategoryUpdateUseCase {

    Category update( Category category, Long id );

}