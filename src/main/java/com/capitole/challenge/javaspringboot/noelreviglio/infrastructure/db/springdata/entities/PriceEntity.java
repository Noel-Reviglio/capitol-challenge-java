package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Builder
public class PriceEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    @ManyToOne( fetch = FetchType.EAGER )
    private BrandEntity brand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priceList;
    @ManyToOne( fetch = FetchType.EAGER )
    private ProductEntity product;
    private int priority;
    private BigDecimal finalPrice;
    @ManyToOne( fetch = FetchType.EAGER )
    @JoinColumn(name = "currency", referencedColumnName = "code")
    private CurrencyEntity currency;
}