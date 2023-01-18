package com.example.user.service;

import com.example.user.model.Admin;
import com.example.user.repository.AdminRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminRepository adminRepository;

    public Admin save(final Admin admin) {
        return adminRepository.save(admin.getUserId(), admin.getFio());
    }

    public Optional<Admin> getAdminByUserId(final Long userId) {
        return adminRepository.getAdminByUserId(userId);
    }

    public Optional<Admin> getAdminById(final Long adminId) {
        return adminRepository.getAdminById(adminId);
    }
}
