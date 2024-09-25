package com.pragma.users.application.handler;

import com.pragma.users.application.dto.user.UserRequest;
import com.pragma.users.application.dto.user.UserResponse;
import com.pragma.users.domain.utils.ApiResponseFormat;

public interface IUserHandler  {
    ApiResponseFormat<UserResponse> saveUser(UserRequest userRequest);
}
