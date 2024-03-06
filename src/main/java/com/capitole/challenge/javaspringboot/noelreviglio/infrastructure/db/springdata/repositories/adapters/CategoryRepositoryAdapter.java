package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.repositories.adapters;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Category;
import com.capitole.challenge.javaspringboot.noelreviglio.domain.ports.out.CategoryRepositoryPort;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.mappers.CategoryEntityMapper;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.repositories.CategoryJPARepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class CategoryRepositoryAdapter implements CategoryRepositoryPort {

    private final CategoryJPARepository categoryRepository;

    @Override
    public Optional<Category> findById(Long id) {
        var categoryEntity = this.categoryRepository.findById(id);
        if( categoryEntity.isEmpty() ) return Optional.empty();
        return categoryEntity.map(CategoryEntityMapper::toDomainModel);
    }

    @Override
    public List<Category> findAll() {
        var categoryEntity = this.categoryRepository.findAll();
        return categoryEntity.stream().map(CategoryEntityMapper::toDomainModel).toList();
    }

    @Override
    @Modifying
    public Category save(Category category) {
        var categoryEntity = CategoryEntityMapper.fromDomainModel(category);
        var savedCategoryEntity = categoryRepository.save(categoryEntity);
        return CategoryEntityMapper.toDomainModel(savedCategoryEntity);
    }

    @Override
    public Category update( Category category ) {
        return this.save( category );
    }

    @Override
    public void delete( Category category ) {
        this.save(category);
    }
}