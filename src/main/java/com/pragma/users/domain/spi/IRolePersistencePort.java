package com.pragma.users.domain.spi;

import com.pragma.users.domain.model.Role;
import com.pragma.users.domain.utils.ApiResponseFormat;

import java.util.List;

public interface IRolePersistencePort {
    ApiResponseFormat<Role> saveRole(Role role);
    ApiResponseFormat<List<Role>> getRoles(int page,int size, String sortDir);
    ApiResponseFormat<Role> getRole(int id);
    Role getRoleByName(String name);
}
