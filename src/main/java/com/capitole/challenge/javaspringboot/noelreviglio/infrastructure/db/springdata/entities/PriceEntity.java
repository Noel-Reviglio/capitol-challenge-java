package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Table( name = "PRICE",
        indexes = {
                @Index( name = "idx_brand", columnList = "brand_id" ),
                @Index( name = "idx_product", columnList = "product_id DESC" ),
                @Index( name = "idx_startdate", columnList = "start_date DESC" ),
                @Index( name = "idx_enddate", columnList = "end_date DESC" ),
                @Index( name = "idx_dates", columnList = "start_date DESC, end_date DESC" ),
                @Index( name = "idx_search", columnList = "brand_id, product_id DESC, start_date DESC, end_date DESC" )
})
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
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    private BrandEntity brand;
    @Column( name = "start_date" )
    private LocalDateTime startDate;
    @Column( name = "end_date" )
    private LocalDateTime endDate;
    @Column( name = "price_list" )
    private int priceList;
    @ManyToOne( fetch = FetchType.EAGER )
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private ProductEntity product;
    private int priority;
    @Column( name = "final_price" )
    private BigDecimal finalPrice;
    @ManyToOne( fetch = FetchType.EAGER )
    @JoinColumn(name = "currency_code", referencedColumnName = "code")
    private CurrencyEntity currency;
}