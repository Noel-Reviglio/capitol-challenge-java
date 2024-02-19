package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.rest.controllers;

import com.capitole.challenge.javaspringboot.noelreviglio.application.services.AuthenticationService;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.rest.dtos.AuthenticationResponseDTO;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.rest.dtos.LoginDTO;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.rest.dtos.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Tag( name = "Authentication" )
public class AuthenticationController {

    private final AuthenticationService authService;

    @Operation(
            description = "Registration of a new user",
            summary = "Registration of a new user with the information provided.",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized",
                            responseCode = "403"
                    )
            }
    )
    @PostMapping("/signup")
    public ResponseEntity<AuthenticationResponseDTO> signup(
            @RequestBody UserDTO request
    ) throws BadRequestException {
        return ResponseEntity.ok( (AuthenticationResponseDTO) this.authService.signup( request ) );
    }

    @Operation(
            description = "Login for a user",
            summary = "Login of a user already registered in the system.",
            responses = {
                    @ApiResponse(
                            description = "Success",
                            responseCode = "200"
                    ),
                    @ApiResponse(
                            description = "Unauthorized",
                            responseCode = "403"
                    )
            }
    )
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponseDTO> login(
            @RequestBody LoginDTO login
    ){
        return ResponseEntity.ok( (AuthenticationResponseDTO) this.authService.login( login) );
    }
}