package com.example.user.controller;

import com.example.user.converter.AdminConverter;
import com.example.user.dto.admin.AdminResponse;
import com.example.user.dto.admin.SaveAdminRequest;
import com.example.user.facade.AdminFacade;
import com.example.user.model.Admin;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class AdminController {
    private final AdminFacade adminFacade;
    private final AdminConverter converter;

    @PostMapping("/admins")
    AdminResponse saveOrGet(@RequestBody SaveAdminRequest request) {
        Admin admin = converter.fromDto(request);

        return converter.toDto(adminFacade.saveOrGet(admin));
    }
}
