package com.capitole.challenge.javaspringboot.noelreviglio.domain.models;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Builder
public class Price {

    private Long id;
    private Brand brand;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int priceList;
    private Product product;
    private int priority;
    private BigDecimal finalPrice;
    private Currency currency;
}