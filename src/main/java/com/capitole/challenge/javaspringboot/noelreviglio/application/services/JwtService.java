package com.capitole.challenge.javaspringboot.noelreviglio.application.services;

import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.jwt.GenerateJwt;
import com.capitole.challenge.javaspringboot.noelreviglio.application.usecases.jwt.JwtManagement;


public interface JwtService extends JwtManagement, GenerateJwt {
}