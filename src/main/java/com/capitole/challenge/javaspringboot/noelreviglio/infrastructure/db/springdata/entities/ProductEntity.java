package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.entities;

import jakarta.persistence.*;
import lombok.*;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Builder
public class ProductEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private String description;
    @ManyToOne( fetch = FetchType.LAZY )
    private CategoryEntity category;

}