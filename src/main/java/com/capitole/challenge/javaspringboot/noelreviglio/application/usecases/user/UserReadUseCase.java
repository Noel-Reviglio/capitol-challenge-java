package com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.user;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface UserReadUseCase {

    Optional<User> getByEmail(String email);
    Optional<User> getById(Long id);
    List<User> getAll();

}