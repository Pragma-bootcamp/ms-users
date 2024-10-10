package com.pragma.users.application.handler.role;

import com.pragma.users.application.dto.role.RoleRequest;
import com.pragma.users.application.dto.role.RoleResponse;
import com.pragma.users.application.mapper.role.RoleMapperRequest;
import com.pragma.users.application.mapper.role.RoleMapperResponse;
import com.pragma.users.domain.api.IRoleServicePort;
import com.pragma.users.domain.exception.PaginationException;
import com.pragma.users.domain.exception.RoleException;
import com.pragma.users.domain.model.Role;
import com.pragma.users.domain.utils.ApiResponseFormat;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.pragma.users.domain.constant.CodeStatus.BAD_REQUEST;
import static com.pragma.users.domain.constant.ErrorMessage.*;
import static com.pragma.users.domain.utils.Element.ASC;
import static com.pragma.users.domain.utils.Element.DESC;
import static com.pragma.users.domain.utils.UtilConstant.*;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleHandler implements IRoleHandler{
    private final IRoleServicePort iRoleServicePort;
    private final RoleMapperRequest roleMapperRequest;
    private final RoleMapperResponse roleMapperResponse;
    @Override
    public ApiResponseFormat<RoleResponse> getRole(int id) {
        validateGetRole(id);
        ApiResponseFormat<Role> role = iRoleServicePort.getRole(id);
        RoleResponse roleResponse = roleMapperResponse.toDto(role.getData());
        return new ApiResponseFormat<>(roleResponse,null);
    }

    @Override
    public ApiResponseFormat<List<RoleResponse>> getRoles(int page, int size, String sortDir) {
        validatePagination(page, size, sortDir);
        ApiResponseFormat<List<Role>> roles = iRoleServicePort.getRoles(page, size, sortDir);
        List<RoleResponse> roleListResponse = roles.getData().stream().map(roleMapperResponse::toDto).toList();
        return new ApiResponseFormat<>(roleListResponse,roles.getMetadata());
    }
    @Override
    public ApiResponseFormat<RoleResponse> saveRole(RoleRequest roleRequest) {
        return null;
    }
    public void validatePagination(int page, int size, String sortDir){
        if(page<PAGE_MIN_VALUE || size < SIZE_MIN_VALUE){
            throw new PaginationException(BAD_REQUEST,PAGINATION_ERROR);
        }
        if(sortDir != null && !(sortDir.equalsIgnoreCase(ASC.name()) ||sortDir.equalsIgnoreCase(DESC.name()) )){
            throw new PaginationException(BAD_REQUEST,SORT_DIR_ERROR);
        }
    }
    public void validateGetRole(int id){
        if(id<MIN_VALUE_ID) throw new RoleException(BAD_REQUEST,ID_NEGATIVE);
    }
}
