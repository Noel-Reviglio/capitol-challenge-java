package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.adapters;

import com.capitole.challenge.javaspringboot.noelreviglio.application.services.AuthenticationService;
import com.capitole.challenge.javaspringboot.noelreviglio.application.services.JwtService;
import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.Role;
import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.User;
import com.capitole.challenge.javaspringboot.noelreviglio.domain.ports.out.UserRepositoryPort;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.entities.UserEntity;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.mappers.UserEntityMapper;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.rest.dtos.AuthenticationResponseDTO;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.rest.dtos.LoginDTO;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.rest.dtos.UserDTO;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceAdapter implements AuthenticationService {

    //TODO: Maybe I could delegate this to UserService.
    private final UserRepositoryPort userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthenticationResponseDTO signup(Object request) throws BadRequestException {
        var userDTO = (UserDTO) request;
        var user = UserEntity.builder()
                .firstname(userDTO.getFirstname())
                .lastname(userDTO.getLastname())
                .email(userDTO.getEmail())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .isActive(true)
                .role(Role.USER)
                .build();
        //TODO: Maybe I could delegate this to UserService.
        var userStored = this.userRepository.findByEmail(user.getEmail());
        if( userStored.isPresent() ) throw new BadRequestException("User already exist.");
        var userDomain = UserEntityMapper.toDomainModel(user);
        userRepository.save( userDomain );
        return this.generateJwt(userDomain);
    }

    @Override
    public AuthenticationResponseDTO login(Object login) {
        var loginDto = (LoginDTO) login;
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDto.getEmail(),
                        loginDto.getPassword()
                )
        );
        var user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow( () -> new UsernameNotFoundException("User not found") );
        return this.generateJwt( user );
    }

    @Override
    public AuthenticationResponseDTO generateJwt(Object user) {
        var userDomain = (User) user;
        var userEntity = UserEntityMapper.fromDomainModel( userDomain );
        var jwtToken = jwtService.generateToken( userEntity );
        return AuthenticationResponseDTO.builder()
                .token(jwtToken)
                .build();
    }

}