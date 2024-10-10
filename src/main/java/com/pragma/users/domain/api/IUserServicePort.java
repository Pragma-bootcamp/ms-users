package com.pragma.users.domain.api;

import com.pragma.users.domain.model.User;
import com.pragma.users.domain.utils.ApiResponseFormat;

public interface IUserServicePort {
    ApiResponseFormat<User> saveUser (User user);
}
