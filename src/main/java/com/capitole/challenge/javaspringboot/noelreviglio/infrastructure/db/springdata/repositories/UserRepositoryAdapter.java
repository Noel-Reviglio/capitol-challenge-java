package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.repositories;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.User;
import com.capitole.challenge.javaspringboot.noelreviglio.domain.ports.out.UserRepositoryPort;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.entities.UserEntity;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.mappers.UserEntityMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    private final UserJPARepository userRepository;

    @Override
    public User save(User user) {
        UserEntity userEntity = UserEntityMapper.fromDomainModel(user);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return UserEntityMapper.toDomainModel(savedUserEntity);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        var userEntity = this.userRepository.findByEmail(email);
        return userEntity.map(UserEntityMapper::toDomainModel);
    }

    @Override
    public Optional<User> findById(Long id) {
        var userEntity = this.userRepository.findById(id);
        return userEntity.map(UserEntityMapper::toDomainModel);
    }

    @Override
    public List<User> findAll() {
        var userEntity = this.userRepository.findAll();
        return userEntity.stream().map(UserEntityMapper::toDomainModel).toList();
    }

    @Override
    public User update(User user) {
        return this.save(user);
    }

    @Override
    public void deleteById(Long id) {
        var user = this.findById(id).orElseThrow( () -> new UsernameNotFoundException("User not found") );
        user.setActive( false );
        this.save(user);
    }
}