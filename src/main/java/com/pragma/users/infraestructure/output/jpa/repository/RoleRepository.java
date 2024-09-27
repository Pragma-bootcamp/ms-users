package com.pragma.users.infraestructure.output.jpa.repository;

import com.pragma.users.infraestructure.output.jpa.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {
    RoleEntity findByName(String name);
}
