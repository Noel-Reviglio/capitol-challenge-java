package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.repositories;

import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.entities.BrandEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandJPARepository extends JpaRepository<BrandEntity, Long> {

    List<BrandEntity> findByEnabled(boolean enabled);
}