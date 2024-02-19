package com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.mappers;

import com.capitole.challenge.javaspringboot.noelreviglio.domain.models.User;
import com.capitole.challenge.javaspringboot.noelreviglio.infrastructure.db.springdata.entities.UserEntity;

public class UserEntityMapper {

    private UserEntityMapper(){}
    public static UserEntity fromDomainModel(User user){
        return new UserEntity(user.getId(), user.getFirstname(), user.getLastname(), user.getEmail(), user.getPassword(), user.isActive(), user.getRole());
    }

    public static User toDomainModel(UserEntity userEntity){
        return new User(userEntity.getId(), userEntity.getFirstname(), userEntity.getLastname(), userEntity.getEmail(), userEntity.getPassword(), userEntity.isActive(), userEntity.getRole());
    }
}