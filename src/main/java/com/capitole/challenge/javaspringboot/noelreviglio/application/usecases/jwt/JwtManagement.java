package com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.jwt;

public interface JwtManagement {

    boolean isTokenValid( String token, Object userDetails );
    String extractUsername(String token);

}