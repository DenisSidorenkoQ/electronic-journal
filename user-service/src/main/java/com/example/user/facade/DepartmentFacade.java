package com.example.user.facade;

import com.example.user.model.Admin;
import com.example.user.model.Department;
import com.example.user.service.DepartmentService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DepartmentFacade {
    private final DepartmentService departmentService;

    public Department save(final Department department) {
        return departmentService.getByName(department.getName())
                .orElseGet(() -> departmentService.save(department));
    }

    public Optional<Department> getById(final Long departmentId) {
        return departmentService.getById(departmentId);
    }

    public Optional<Department> getByName(final String name) {
        return departmentService.getByName(name);
    }
}
