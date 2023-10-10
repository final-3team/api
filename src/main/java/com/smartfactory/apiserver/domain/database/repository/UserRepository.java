package com.smartfactory.apiserver.domain.database.repository;

import com.smartfactory.apiserver.domain.database.entity.UserEntity;
import com.smartfactory.apiserver.domain.database.repository.custom.CustomUserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long>,
        QuerydslPredicateExecutor<UserEntity>, CustomUserRepository{
    Optional<UserEntity> findUserEntityByUserId(String userId);
}