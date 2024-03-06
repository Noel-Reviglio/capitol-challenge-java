package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.repositories;

import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.entities.CurrencyEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CurrencyJPARepository extends JpaRepository<CurrencyEntity, Long> {

    Optional<CurrencyEntity> findByCode( String code );
    List<CurrencyEntity> findByEnabled( boolean enabled );
}