package com.pragma.users.domain.usecase;

import com.pragma.users.domain.api.IAuthenticationServicePort;
import com.pragma.users.domain.spi.IAuthenticationSecurityPort;
import com.pragma.users.infraestructure.output.security.adapter.AuthenticationAdapter;

public class AuthenticationUseCase implements IAuthenticationServicePort {
    private final IAuthenticationSecurityPort authenticationSecurityPort;

    public AuthenticationUseCase(IAuthenticationSecurityPort authenticationSecurityPort) {
        this.authenticationSecurityPort = authenticationSecurityPort;
    }

    @Override
    public String encryptPassword(String password) {
        return "";
    }

    @Override
    public String decryptPassword(String encryptedPassword) {
        return "";
    }
}
