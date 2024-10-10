package com.pragma.users.domain.api;

public interface IAuthenticationServicePort {
    String encryptPassword(String password);
    String decryptPassword(String encryptedPassword);
}
