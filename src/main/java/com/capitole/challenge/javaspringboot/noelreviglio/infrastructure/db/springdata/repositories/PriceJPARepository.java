package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.repositories;

import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.entities.PriceEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface PriceJPARepository extends JpaRepository<PriceEntity, Long> {

    @Query( value = "SELECT * FROM Price WHERE p.product_id = :productId AND p.brand_id = :brandId " +
                    "AND :requestedDate BETWEEN p.start_date AND p.end_date",
            nativeQuery = true )
    Page<PriceEntity> findByProductIdAndBrandIdAndDateBetween(@Param( "productId" ) Long productId,
                                                              @Param( "brandId" ) Long brandId,
                                                              @Param( "requestedDate" ) LocalDateTime requestedDate,
                                                              Pageable pageable);
}