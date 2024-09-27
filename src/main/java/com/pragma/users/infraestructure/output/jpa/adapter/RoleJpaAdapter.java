package com.pragma.users.infraestructure.output.jpa.adapter;

import com.pragma.users.domain.constant.ErrorMessage;
import com.pragma.users.domain.exception.RoleException;
import com.pragma.users.domain.model.Role;
import com.pragma.users.domain.spi.IRolePersistencePort;
import com.pragma.users.domain.utils.ApiResponseFormat;
import com.pragma.users.domain.utils.MetadataResponse;
import com.pragma.users.infraestructure.output.jpa.entity.RoleEntity;
import com.pragma.users.infraestructure.output.jpa.mapper.RoleDboMapper;
import com.pragma.users.infraestructure.output.jpa.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

import static com.pragma.users.domain.utils.Element.ASC;

@RequiredArgsConstructor
public class RoleJpaAdapter implements IRolePersistencePort {
    private final RoleRepository roleRepository;
    private final RoleDboMapper roleDboMapper;

    @Override
    public ApiResponseFormat<Role> saveRole(Role role) {
        RoleEntity existRole = roleRepository.findByName(role.getName());
        if (existRole != null) {
            throw new RoleException(HttpStatus.CONFLICT.value(),
                    String.format(ErrorMessage.ROLE_ALREADY_EXIST, role.getName()));
        }
        RoleEntity roleToCreate = roleDboMapper.toDbo(role);
        RoleEntity savedRole = roleRepository.save(roleToCreate);
        return new ApiResponseFormat<>(roleDboMapper.toDomain(savedRole), null);
    }

    @Override
    public ApiResponseFormat<List<Role>> getRoles(int page, int size, String sortDir) {
        Pageable pageable = PageRequest.of(page, size,
                Sort.Direction.fromString(sortDir != null ? sortDir : ASC.name()));
        Page<RoleEntity> rolesPage = roleRepository.findAll(pageable);
        List<Role> roles = rolesPage.getContent().stream().map(roleDboMapper::toDomain).toList();
        MetadataResponse metadata = new MetadataResponse(page, rolesPage.getTotalElements(),
                rolesPage.getTotalPages(), size);
        return new ApiResponseFormat<>(roles,metadata);
    }

    @Override
    public ApiResponseFormat<Role> getRole(int id) {
        Optional<RoleEntity> roleExist = roleRepository.findById(id);
        if(roleExist.isEmpty()) {
            throw new RoleException(HttpStatus.NOT_FOUND.value(), ErrorMessage.ROLE_NOT_FOUND);
        }
        Role role = roleDboMapper.toDomain(roleExist.get());
        return new ApiResponseFormat<>(role, null);
    }
}
