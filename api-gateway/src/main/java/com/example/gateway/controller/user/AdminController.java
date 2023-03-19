package com.example.gateway.controller.user;

import com.example.gateway.client.UserClient;
import com.example.gateway.dto.admin.AdminResponse;
import com.example.gateway.dto.admin.SaveAdminRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@EnableMethodSecurity
public class AdminController {
    private final UserClient userClient;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/admins")
    AdminResponse saveOrGet(@RequestBody SaveAdminRequest request) {
        return userClient.saveOrGetAdmin(request);
    }
}
