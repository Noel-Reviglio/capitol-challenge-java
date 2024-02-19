package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.rest.dtos;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import org.springframework.lang.NonNull;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Builder
public class UserDTO {

    private Long id;
    @NonNull
    private String firstname;
    @NonNull
    private String lastname;
    @NonNull
    private String email;
    @NonNull
    private String password;
    private boolean isActive;
    @Enumerated(EnumType.STRING)
    private Role role;
}
