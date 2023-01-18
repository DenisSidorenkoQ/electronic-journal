package com.example.user.controller;

import com.example.user.converter.DepartmentConverter;
import com.example.user.dto.department.DepartmentResponse;
import com.example.user.dto.department.SaveDepartmentRequest;
import com.example.user.facade.DepartmentFacade;
import com.example.user.model.Admin;
import com.example.user.model.Department;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentFacade departmentFacade;
    private final DepartmentConverter converter;

    @PostMapping
    DepartmentResponse save(@RequestBody SaveDepartmentRequest request) {
        return converter.toDto(departmentFacade.save(request.getName()));
    }

    @GetMapping("{departmentId}")
    ResponseEntity getById(@PathVariable("departmentId") final Long departmentId) {
        Optional<Department> department = departmentFacade.getById(departmentId);

        return department
                .map(value -> new ResponseEntity(converter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }
}
