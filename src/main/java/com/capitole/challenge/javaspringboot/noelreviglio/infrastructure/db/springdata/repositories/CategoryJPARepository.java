package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.repositories;

import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.entities.CategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryJPARepository extends JpaRepository<CategoryEntity, Long> {

}