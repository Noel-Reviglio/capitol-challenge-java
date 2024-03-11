package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.repositories.adapters;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.User;
import com.capitole.challenge.javaspringboot.noelreviglio.domain.ports.out.UserRepositoryPort;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.mappers.UserEntityMapper;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.repositories.UserJPARepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserJPARepository userRepository;

    @Override
    @Modifying
    public User save( User user ) {
        var userEntity = UserEntityMapper.fromDomainModel(user);
        var savedUserEntity = userRepository.save(userEntity);
        return UserEntityMapper.toDomainModel(savedUserEntity);
    }

    @Override
    public Optional<User> findByEmail( String email ) {
        var userEntity = this.userRepository.findByEmail(email);
        if( userEntity.isEmpty() ) return Optional.empty();
        return userEntity.map(UserEntityMapper::toDomainModel);
    }

    @Override
    public Optional<User> findById(Long id) {
        var userEntity = this.userRepository.findById(id);
        if( userEntity.isEmpty() ) return Optional.empty();
        return userEntity.map(UserEntityMapper::toDomainModel);
    }

    @Override
    public List<User> findAll() {
        var userEntities = this.userRepository.findAll();
        return userEntities.stream().map(UserEntityMapper::toDomainModel).toList();
    }

    @Override
    public User update( User user ) {
        return this.save( user );
    }

    @Override
    public void delete( User user ) {
        this.save( user );
    }
}