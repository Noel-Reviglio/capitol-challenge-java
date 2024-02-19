package com.capitole.challenge.javaspringboot.noelreviglio.domain.ports.out;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryPort {

    User save(User user);
    Optional<User> findByEmail(String email);
    Optional<User> findById(Long id);
    List<User> findAll();
    User update(User user);
    void deleteById(Long id);

}