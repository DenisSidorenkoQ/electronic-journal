package com.example.user.converter;

import com.example.user.dto.admin.AdminResponse;
import com.example.user.model.Admin;
import org.mapstruct.Mapper;

@Mapper
public interface AdminConverter {
    AdminResponse toDto(final Admin admin);
}
