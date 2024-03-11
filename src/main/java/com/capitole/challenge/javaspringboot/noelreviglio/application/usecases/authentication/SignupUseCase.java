package com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.authentication;

import org.apache.coyote.BadRequestException;

public interface SignupUseCase {

    Object signup(Object request) throws BadRequestException;

}