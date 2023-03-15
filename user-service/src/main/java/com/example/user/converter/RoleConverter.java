package com.example.user.converter;

import com.example.user.dto.role.RoleResponse;
import com.example.user.dto.role.SaveRoleRequest;
import com.example.user.model.Role;
import org.mapstruct.Mapper;

@Mapper
public interface RoleConverter {
    Role fromDto(SaveRoleRequest request);

    RoleResponse toDto(Role saveOrGet);
}
