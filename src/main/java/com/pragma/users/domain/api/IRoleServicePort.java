package com.pragma.users.domain.api;

import com.pragma.users.domain.model.Role;
import com.pragma.users.domain.utils.ApiResponseFormat;

import java.util.List;

public interface IRoleServicePort {
    ApiResponseFormat<List<Role>> getRoles(int page,int size,String sortDir);
    ApiResponseFormat<Role> getRole(int id);
    ApiResponseFormat<Role> saveRole(Role role);
}
