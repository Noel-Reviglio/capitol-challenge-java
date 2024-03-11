package com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.user;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.User;

public interface UserCreateUseCase {

    User save(User user);

}