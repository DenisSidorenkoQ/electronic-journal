package com.example.gateway.controller.user;

import com.example.gateway.client.UserClient;
import com.example.gateway.dto.department.DepartmentResponse;
import com.example.gateway.dto.department.SaveDepartmentRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@EnableMethodSecurity
public class DepartmentController {
    private final UserClient userClient;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/departments")
    DepartmentResponse saveOrGet(@RequestBody SaveDepartmentRequest request) {
        return userClient.saveOrGetDepartment(request);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/departments")
    List<DepartmentResponse> getDepartmentList() {
        return userClient.getDepartmentList();
    }
}
