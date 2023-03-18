package com.example.user.service;

import com.example.user.model.Role;
import com.example.user.repository.RoleRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository repository;

    public Role save(Role role) {
        return repository.save(role);
    }

    public List<Role> getRoleList() {
        return repository.getRoleList();
    }

    public Role getRoleById(Long roleId) {
        return repository.getRoleById(roleId);
    }
}
