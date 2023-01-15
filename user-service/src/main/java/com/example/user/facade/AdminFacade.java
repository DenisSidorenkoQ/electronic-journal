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

    public Admin save(final Long userId, final String fio) {
        return adminService.getAdminByUserId(userId)
                .orElseGet(() -> adminService.save(userId, fio));
    }


    public Optional<Admin> getAdminByUserId(final Long userId) {
        return adminService.getAdminByUserId(userId);
    }

    public Optional<Admin> getAdminById(final Long adminId) {
        return adminService.getAdminById(adminId);
    }
}
