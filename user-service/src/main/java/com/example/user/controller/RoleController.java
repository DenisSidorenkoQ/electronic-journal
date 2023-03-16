package com.example.user.controller;

import com.example.user.converter.RoleConverter;
import com.example.user.dto.role.RoleResponse;
import com.example.user.dto.role.SaveRoleRequest;
import com.example.user.facade.RoleFacade;
import com.example.user.model.Role;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class RoleController {
    private final RoleConverter converter;
    private final RoleFacade roleFacade;

    @PostMapping("/roles")
    RoleResponse saveOrGet(@RequestBody SaveRoleRequest request) {
        Role role = converter.fromDto(request);

        return converter.toDto(roleFacade.saveOrGet(role));
    }

    @GetMapping("/roles")
    List<RoleResponse> getRoleList() {
        List<Role> roleList = roleFacade.getRoleList();
        return roleList.stream().map(converter::toDto).collect(Collectors.toList());
    }

    @GetMapping("/role/{roleId}")
    RoleResponse getRoleById(@PathVariable("roleId") Long roleId) {
        Role role = roleFacade.getRoleById(roleId);
        return converter.toDto(role);
    }
}
