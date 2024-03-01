package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Table
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Builder
public class CurrencyEntity {

    @Id
    private String code;
    private String name;
}