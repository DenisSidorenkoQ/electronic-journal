package com.example.user.controller;

import com.example.user.converter.DepartmentConverter;
import com.example.user.dto.department.DepartmentResponse;
import com.example.user.dto.department.SaveDepartmentRequest;
import com.example.user.facade.DepartmentFacade;
import com.example.user.model.Department;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentFacade departmentFacade;
    private final DepartmentConverter converter;

    @PostMapping("/departments")
    DepartmentResponse saveOrGet(@RequestBody SaveDepartmentRequest request) {
        Department department = converter.fromDto(request);

        return converter.toDto(departmentFacade.save(department));
    }

    @GetMapping("/departments")
    List<DepartmentResponse> getDepartmentList() {
        return departmentFacade.getDepartmentList().stream().map(converter::toDto).collect(Collectors.toList());
    }
}
