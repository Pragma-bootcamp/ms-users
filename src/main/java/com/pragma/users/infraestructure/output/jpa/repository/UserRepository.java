package com.pragma.users.infraestructure.output.jpa.repository;

import com.pragma.users.infraestructure.output.jpa.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);
}
