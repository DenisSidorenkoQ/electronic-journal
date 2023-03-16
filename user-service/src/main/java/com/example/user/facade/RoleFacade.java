package com.example.user.facade;

import com.example.user.model.Role;
import com.example.user.service.RoleService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RoleFacade {
    private final RoleService roleService;

    public Role saveOrGet(Role role) {
        return roleService.getByRoleName(role.getName())
                .orElseGet(() -> roleService.save(role));
    }

    public List<Role> getRoleList() {
        return roleService.getRoleList();
    }

    public Role getRoleById(Long roleId) {
        return roleService.getRoleById(roleId);
    }
}
