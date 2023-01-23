package com.example.user.service;

import com.example.user.model.Admin;
import com.example.user.model.Department;
import com.example.user.repository.DepartmentRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Optional<Department> getByName(final String name) {
        return departmentRepository.getByName(name);
    }

    public Department save(final Department department) {
        return departmentRepository.save(department);
    }

    public Optional<Department> getById(final Long departmentId) {
        return departmentRepository.getById(departmentId);
    }
}
