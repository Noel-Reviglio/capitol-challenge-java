package com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.jwt;

import java.util.Map;

public interface GenerateJwt {

    String generateToken( Object userDetails );
    String generateToken(Map<String, Object> extraClaims, Object userDetails );

}