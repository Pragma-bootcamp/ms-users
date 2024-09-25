package com.pragma.users.infraestructure.output.jpa.mapper;

import com.pragma.users.domain.model.User;
import com.pragma.users.infraestructure.output.jpa.entity.UserEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDboMapper {
    UserEntity toDbo(User user);

    @InheritInverseConfiguration
    User toDomain(UserEntity userEntity);
}
