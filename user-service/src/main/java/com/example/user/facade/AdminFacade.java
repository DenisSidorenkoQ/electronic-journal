package com.example.user.facade;

import com.example.user.model.Admin;
import com.example.user.service.AdminService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdminFacade {
    private final AdminService adminService;

    public Admin saveOrGet(final Admin admin) {
        return adminService.getAdminByUserId(admin.getUserId())
                .orElseGet(() -> adminService.save(admin));
    }


    public Optional<Admin> getByUserId(final Long userId) {
        return adminService.getAdminByUserId(userId);
    }

    public Optional<Admin> getById(final Long adminId) {
        return adminService.getAdminById(adminId);
    }
}
