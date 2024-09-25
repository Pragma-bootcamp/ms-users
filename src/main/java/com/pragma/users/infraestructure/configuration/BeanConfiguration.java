package com.pragma.users.infraestructure.configuration;

import com.pragma.users.domain.api.IUserServicePort;
import com.pragma.users.domain.spi.IUserPersistentPort;
import com.pragma.users.domain.usecase.UserUseCase;
import com.pragma.users.infraestructure.output.jpa.adapter.UserJpaAdapter;
import com.pragma.users.infraestructure.output.jpa.mapper.UserDboMapper;
import com.pragma.users.infraestructure.output.jpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final UserRepository userRepository;
    private final UserDboMapper userDboMapper;
    @Bean
    public IUserPersistentPort userPersistentPort() {
        return new UserJpaAdapter(userRepository,userDboMapper);
    }
    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistentPort());
    }
}
