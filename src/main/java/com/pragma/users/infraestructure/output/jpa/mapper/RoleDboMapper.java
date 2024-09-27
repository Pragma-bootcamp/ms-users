package com.pragma.users.infraestructure.output.jpa.mapper;

import com.pragma.users.domain.model.Role;
import com.pragma.users.infraestructure.output.jpa.entity.RoleEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleDboMapper {
    Role toDomain(RoleEntity roleEntity);

    @InheritInverseConfiguration
    RoleEntity toDbo (Role role);
}
