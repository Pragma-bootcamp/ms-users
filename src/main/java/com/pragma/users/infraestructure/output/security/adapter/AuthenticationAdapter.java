package com.pragma.users.infraestructure.output.security.adapter;

import com.pragma.users.domain.spi.IAuthenticationSecurityPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class AuthenticationAdapter implements IAuthenticationSecurityPort {
    private final PasswordEncoder passwordEncoder;

    @Override
    public String encryptPassword(String password) {
        return passwordEncoder.encode(password);
    }

}
