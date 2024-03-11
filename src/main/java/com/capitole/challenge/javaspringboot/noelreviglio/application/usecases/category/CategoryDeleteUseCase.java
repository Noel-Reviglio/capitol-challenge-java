package com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.category;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Category;

public interface CategoryDeleteUseCase {

    void delete( Category category, Long id );

}