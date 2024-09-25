package com.pragma.users.application.mapper.user;

import com.pragma.users.application.dto.user.UserRequest;
import com.pragma.users.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserMapperRequest {
    User toDomain (UserRequest userRequest);
}
