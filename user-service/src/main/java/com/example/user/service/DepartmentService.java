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

    public Optional<Department> getDepartmentByName(final String name) {
        return departmentRepository.getDepartmentByName(name);
    }

    public Department save(final String name) {
        return departmentRepository.save(name);
    }

    public Optional<Department> getById(final Long departmentId) {
        return departmentRepository.getById(departmentId);
    }
}
