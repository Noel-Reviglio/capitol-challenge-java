package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.repositories;

import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.entities.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductJPARepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByEnabled(boolean enabled );

}