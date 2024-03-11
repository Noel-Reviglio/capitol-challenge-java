package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.entities;

import jakarta.persistence.*;
import lombok.*;

@Table( name = "BRAND" )
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Builder
public class BrandEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private Long id;
    private String name;
    private boolean enabled;
}