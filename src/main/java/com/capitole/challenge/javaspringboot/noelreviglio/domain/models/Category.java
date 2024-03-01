package com.capitole.challenge.javaspringboot.noelreviglio.domain.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Builder
public class Category {

    private Long id;
    private String name;
    private String description;
}