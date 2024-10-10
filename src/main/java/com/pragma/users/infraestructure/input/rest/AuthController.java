package com.pragma.users.infraestructure.input.rest;

import com.pragma.users.application.dto.user.UserRequest;
import com.pragma.users.application.dto.user.UserResponse;
import com.pragma.users.application.handler.user.IUserHandler;
import com.pragma.users.domain.utils.ApiResponseFormat;
import com.pragma.users.infraestructure.constant.InfrastructureConstant;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name = "Auth")
@RequiredArgsConstructor
public class AuthController {
    private final IUserHandler userHandler;

    @PostMapping("/register/aux_bodega")
    public ApiResponseFormat<UserResponse> registerAuxBodega (@Valid @RequestBody UserRequest userRequest) {
        userRequest.setRole(InfrastructureConstant.WAREHOUSE_AUX_ROLE);
        return userHandler.saveUser(userRequest);
    }
}
