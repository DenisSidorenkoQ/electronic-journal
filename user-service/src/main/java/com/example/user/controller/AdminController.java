package com.example.user.controller;

import com.example.user.dto.admin.GetAdminByUserIdRequest;
import com.example.user.dto.admin.SaveAdminRequest;
import com.example.user.facade.AdminFacade;
import com.example.user.model.Admin;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {
    private final AdminFacade adminFacade;

    @PostMapping
    Admin save(@RequestBody SaveAdminRequest request) {
        return adminFacade.save(request.getUserId(), request.getFio());
    }

    @GetMapping
    ResponseEntity getAdminByUserId(@RequestBody final GetAdminByUserIdRequest request) {
        Optional<Admin> admin = adminFacade.getAdminByUserId(request.getUserId());

        return admin
                .map(value -> new ResponseEntity(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }

    @GetMapping("{adminId}")
    ResponseEntity getAdminById(@PathVariable("adminId") final Long adminId) {
        Optional<Admin> admin = adminFacade.getAdminById(adminId);

        return admin
                .map(value -> new ResponseEntity(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }
}