package com.example.gateway.controller.user;

import com.example.gateway.client.UserClient;
import com.example.gateway.dto.role.RoleResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@EnableMethodSecurity
public class RoleController {
    private final UserClient userClient;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/roles")
    List<RoleResponse> getRoleList() {
        return  userClient.getRoleList();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/role/{roleId}")
    RoleResponse getRoleById(@PathVariable("roleId") Long roleId) {
        return userClient.getRoleById(roleId);
    }
}
