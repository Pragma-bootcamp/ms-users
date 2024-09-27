package com.pragma.users.infraestructure.output.jpa.adapter;

import com.pragma.users.domain.constant.ErrorMessage;
import com.pragma.users.domain.exception.UserException;
import com.pragma.users.domain.model.User;
import com.pragma.users.domain.spi.IUserPersistencePort;
import com.pragma.users.domain.utils.ApiResponseFormat;
import com.pragma.users.infraestructure.output.jpa.entity.UserEntity;
import com.pragma.users.infraestructure.output.jpa.mapper.UserDboMapper;
import com.pragma.users.infraestructure.output.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
public class UserJpaAdapter implements IUserPersistencePort {
    private final UserRepository userRepository;
    private final UserDboMapper userDboMapper;
    @Override
    public ApiResponseFormat<User> saveUser(User user) {
        UserEntity userExist = userRepository.findByEmail(user.getEmail());
        if(userExist != null) {
            throw  new UserException(HttpStatus.CONFLICT.value(), ErrorMessage.USER_ALREADY_EXISTS);
        }
        UserEntity toCrete = userDboMapper.toDbo(user);
        UserEntity created = userRepository.save(toCrete);
        User userCreated = userDboMapper.toDomain(created);
        return new ApiResponseFormat<>(userCreated,null);
    }
}
