package com.pragma.users.infraestructure.configuration;

import com.pragma.users.domain.api.IAuthenticationServicePort;
import com.pragma.users.domain.api.IRoleServicePort;
import com.pragma.users.domain.api.IUserServicePort;
import com.pragma.users.domain.spi.IAuthenticationSecurityPort;
import com.pragma.users.domain.spi.IRolePersistencePort;
import com.pragma.users.domain.spi.IUserPersistencePort;
import com.pragma.users.domain.usecase.AuthenticationUseCase;
import com.pragma.users.domain.usecase.RoleUseCase;
import com.pragma.users.domain.usecase.UserUseCase;
import com.pragma.users.infraestructure.output.jpa.adapter.RoleJpaAdapter;
import com.pragma.users.infraestructure.output.jpa.adapter.UserJpaAdapter;
import com.pragma.users.infraestructure.output.jpa.mapper.RoleDboMapper;
import com.pragma.users.infraestructure.output.jpa.mapper.UserDboMapper;
import com.pragma.users.infraestructure.output.jpa.repository.RoleRepository;
import com.pragma.users.infraestructure.output.jpa.repository.UserRepository;
import com.pragma.users.infraestructure.output.security.adapter.AuthenticationAdapter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final UserRepository userRepository;
    private final UserDboMapper userDboMapper;
    private final RoleRepository roleRepository;
    private final RoleDboMapper roleDboMapper;

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public IAuthenticationSecurityPort authenticationSecurityPort() {
        return new AuthenticationAdapter(encoder());
    }
    @Bean
    IAuthenticationServicePort authenticationServicePort() {
        return new AuthenticationUseCase(authenticationSecurityPort());
    }
    @Bean
    public IRolePersistencePort rolePersistencePort() {
        return new RoleJpaAdapter(roleRepository, roleDboMapper);
    }

    @Bean
    public IRoleServicePort roleServicePort() {
        return new RoleUseCase(rolePersistencePort());
    }

    @Bean
    public IUserPersistencePort userPersistentPort() {
        return new UserJpaAdapter(userRepository, userDboMapper);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistentPort(), rolePersistencePort(),authenticationSecurityPort() );
    }




}
