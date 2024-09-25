package com.pragma.users.application.dto.user;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserResponse {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String password;
    private LocalDate birthdate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
