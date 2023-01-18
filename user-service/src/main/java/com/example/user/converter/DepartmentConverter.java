package com.example.user.converter;

import com.example.user.dto.department.DepartmentResponse;
import com.example.user.model.Department;
import org.mapstruct.Mapper;

@Mapper
public interface DepartmentConverter {
    DepartmentResponse toDto(final Department department);
}
