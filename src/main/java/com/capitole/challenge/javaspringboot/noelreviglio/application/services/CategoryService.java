package com.capitole.challenge.javaspringboot.noelreviglio.application.services;

import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.category.CategoryCreateUseCase;
import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.category.CategoryDeleteUseCase;
import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.category.CategoryReadUseCase;
import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.category.CategoryUpdateUseCase;

public interface CategoryService extends CategoryCreateUseCase, CategoryReadUseCase, CategoryUpdateUseCase, CategoryDeleteUseCase {
}