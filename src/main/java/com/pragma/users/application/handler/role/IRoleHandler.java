package com.pragma.users.application.handler.role;

import com.pragma.users.application.dto.role.RoleRequest;
import com.pragma.users.application.dto.role.RoleResponse;
import com.pragma.users.domain.utils.ApiResponseFormat;

import java.util.List;

public interface IRoleHandler {
    ApiResponseFormat<RoleResponse> getRole(int id);
    ApiResponseFormat<List<RoleResponse>> getRoles(int page, int size, String sortDir);
    ApiResponseFormat<RoleResponse> saveRole(RoleRequest roleRequest);
}
