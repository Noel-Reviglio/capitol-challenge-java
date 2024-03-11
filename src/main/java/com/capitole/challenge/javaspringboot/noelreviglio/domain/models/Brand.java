package com.capitole.challenge.javaspringboot.noelreviglio.domain.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Builder
public class Brand {

    private Long id;
    private String name;
    private boolean enabled;
}