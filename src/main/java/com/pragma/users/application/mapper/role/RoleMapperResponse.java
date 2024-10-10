package com.pragma.users.application.mapper.role;

import com.pragma.users.application.dto.role.RoleRequest;
import com.pragma.users.application.dto.role.RoleResponse;
import com.pragma.users.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface RoleMapperResponse {
    RoleResponse toDto(Role role);
}
