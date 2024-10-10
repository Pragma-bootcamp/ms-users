package com.pragma.users.infraestructure.input.rest;

import com.pragma.users.application.dto.user.UserRequest;
import com.pragma.users.application.dto.user.UserResponse;
import com.pragma.users.application.handler.user.IUserHandler;
import com.pragma.users.domain.utils.ApiResponseFormat;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Tag(name = "User")
@RequiredArgsConstructor
public class UserController {
    private final IUserHandler iUserHandler;

    @PostMapping()
    public ApiResponseFormat<UserResponse> createUserAux (@Valid @RequestBody UserRequest userRequest) {
        return iUserHandler.saveUser(userRequest);
    }
}
