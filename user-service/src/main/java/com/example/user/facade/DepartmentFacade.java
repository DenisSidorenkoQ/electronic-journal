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

    public Department save(final String name) {
        return departmentService.getDepartmentByName(name)
                .orElseGet(() -> departmentService.save(name));
    }

    public Optional<Department> getById(final Long departmentId) {
        return departmentService.getById(departmentId);
    }
}
