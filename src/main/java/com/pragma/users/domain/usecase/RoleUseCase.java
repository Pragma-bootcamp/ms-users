package com.pragma.users.domain.usecase;

import com.pragma.users.domain.api.IRoleServicePort;
import com.pragma.users.domain.constant.ErrorMessage;
import com.pragma.users.domain.constant.RoleConstant;
import com.pragma.users.domain.exception.RoleException;
import com.pragma.users.domain.model.Role;
import com.pragma.users.domain.spi.IRolePersistencePort;
import com.pragma.users.domain.utils.ApiResponseFormat;

import java.util.List;

import static com.pragma.users.domain.constant.CodeStatus.BAD_REQUEST;


public class RoleUseCase implements IRoleServicePort {
    private final IRolePersistencePort rolePersistencePort;

    public RoleUseCase(IRolePersistencePort rolePersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public ApiResponseFormat<List<Role>> getRoles(int page, int size, String sortDir) {
        return rolePersistencePort.getRoles(page, size, sortDir);
    }

    @Override
    public ApiResponseFormat<Role> getRole(int id) {
        return rolePersistencePort.getRole(id);
    }

    @Override
    public ApiResponseFormat<Role> saveRole(Role role) {
        validateRole(role);
        return rolePersistencePort.saveRole(role);
    }

    public void validateRole(Role role) {
        if (role.getName() == null) {
            throw new RoleException(BAD_REQUEST, ErrorMessage.ROLE_NAME_NULL_ERROR);
        }
        if (role.getName().length() < RoleConstant.MIN_NAME_LENGTH || role.getName().length() > RoleConstant.MAX_NAME_LENGTH) {
            throw new RoleException(BAD_REQUEST, ErrorMessage.ROLE_NAME_LENGTH_ERROR);
        }
        if (role.getDescription() == null) {
            throw new RoleException(BAD_REQUEST, ErrorMessage.ROLE_DESCRIPTION_NULL_ERROR);
        }
        if (role.getDescription().length() < RoleConstant.MIN_DESCRIPTION_LENGTH
                || role.getDescription().length() > RoleConstant.MAX_DESCRIPTION_LENGTH) {
            throw new RoleException(BAD_REQUEST, ErrorMessage.ROLE_DESCRIPTION_LENGTH_ERROR);
        }

    }
}
