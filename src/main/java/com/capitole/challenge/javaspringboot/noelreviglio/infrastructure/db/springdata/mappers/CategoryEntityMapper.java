package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.mappers;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Category;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.entities.CategoryEntity;

public class CategoryEntityMapper {

    private CategoryEntityMapper(){}
    public static CategoryEntity fromDomainModel(Category category){
        return new CategoryEntity( category.getId(), category.getName(), category.getDescription() );
    }

    public static Category toDomainModel( CategoryEntity categoryEntity){
        return new Category(categoryEntity.getId(), categoryEntity.getName(), categoryEntity.getDescription() );
    }
}