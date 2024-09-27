package com.pragma.users.domain.spi;

import com.pragma.users.domain.model.User;
import com.pragma.users.domain.utils.ApiResponseFormat;

public interface IUserPersistencePort {
    ApiResponseFormat<User> saveUser(User user);
}
