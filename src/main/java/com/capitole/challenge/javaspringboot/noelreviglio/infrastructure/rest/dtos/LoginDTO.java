package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.rest.dtos;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginDTO {

    private String email;
    private String password;
}
