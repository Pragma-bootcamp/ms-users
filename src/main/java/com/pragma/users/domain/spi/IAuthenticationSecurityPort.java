package com.pragma.users.domain.spi;

public interface IAuthenticationSecurityPort {
    String encryptPassword(String password);
}
