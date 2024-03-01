package com.capitole.challenge.javaspringboot.noelreviglio.domain.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Builder
public class Currency {

    private String code;
    private String name;
    private boolean enabled;
}