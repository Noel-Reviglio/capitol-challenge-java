package com.capitole.challenge.javaspringboot.noelreviglio.application.services;

import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.user.UserCreateUseCase;
import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.user.UserDeleteUseCase;
import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.user.UserReadUseCase;
import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.user.UserUpdateUseCase;

public interface UserService extends UserCreateUseCase, UserReadUseCase, UserUpdateUseCase, UserDeleteUseCase {
}