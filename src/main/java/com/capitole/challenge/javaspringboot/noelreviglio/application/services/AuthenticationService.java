package com.capitole.challenge.javaspringboot.noelreviglio.application.services;

import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.authentication.LoginUseCase;
import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.authentication.SignupUseCase;

public interface AuthenticationService extends LoginUseCase, SignupUseCase {
}