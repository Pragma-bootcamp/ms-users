package com.pragma.users.application.handler.user;

import com.pragma.users.application.dto.user.UserRequest;
import com.pragma.users.application.dto.user.UserResponse;
import com.pragma.users.application.mapper.user.UserMapperRequest;
import com.pragma.users.application.mapper.user.UserMapperResponse;
import com.pragma.users.domain.api.IUserServicePort;
import com.pragma.users.domain.model.User;
import com.pragma.users.domain.utils.ApiResponseFormat;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserHandler implements IUserHandler {
    private final IUserServicePort iUserServicePort;
    private final UserMapperRequest userMapperRequest;
    private final UserMapperResponse userMapperResponse;

    @Override
    public ApiResponseFormat<UserResponse> saveUser(UserRequest userRequest) {
        System.out.print(userRequest.getName());
        User user = userMapperRequest.toDomain(userRequest);
        ApiResponseFormat<User> savedUser = iUserServicePort.saveUser(user);
        UserResponse userResponse = userMapperResponse.toDto(savedUser.getData());
        return new ApiResponseFormat<>(userResponse,null);

    }
}
