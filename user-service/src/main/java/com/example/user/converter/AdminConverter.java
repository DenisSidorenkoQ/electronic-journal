package com.example.user.converter;

import com.example.user.dto.admin.AdminResponse;
import com.example.user.dto.admin.SaveAdminRequest;
import com.example.user.model.Admin;
import org.mapstruct.Mapper;

@Mapper
public interface AdminConverter {
    Admin fromDto(final SaveAdminRequest admin);
    
    AdminResponse toDto(final Admin admin);
}
