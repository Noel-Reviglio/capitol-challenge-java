package com.capitole.challenge.javaspringboot.noelreviglio.application.services;

import org.apache.coyote.BadRequestException;

public interface AuthenticationService {
    Object signup(Object request) throws BadRequestException;

    Object login(Object login);

    Object generateJwt(Object user);
}
