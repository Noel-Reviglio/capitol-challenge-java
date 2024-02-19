package com.capitole.challenge.javaspringboot.noelreviglio.domain.models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Builder
public class User {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private boolean isActive;
    private Role role;
}