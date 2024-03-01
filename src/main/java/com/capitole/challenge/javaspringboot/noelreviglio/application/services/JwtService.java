package com.capitole.challenge.javaspringboot.noelreviglio.application.services;

import java.util.Map;

public interface JwtService {

    String generateToken( Object userDetails );
    String generateToken( Map<String, Object> extraClaims, Object userDetails );
    boolean isTokenValid( String token, Object userDetails );
    String extractUsername(String token);
}
