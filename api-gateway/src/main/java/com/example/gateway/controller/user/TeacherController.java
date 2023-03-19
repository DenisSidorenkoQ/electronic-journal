package com.example.gateway.controller.user;

import com.example.gateway.client.UserClient;
import com.example.gateway.dto.teacher.SaveTeacherRequest;
import com.example.gateway.dto.teacher.TeacherResponse;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@EnableMethodSecurity
public class TeacherController {
    private final UserClient userClient;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/teachers")
    TeacherResponse saveOrGet(@RequestBody SaveTeacherRequest request) {
        return userClient.saveOrGetTeacher(request);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @GetMapping("/user/{userId}/teachers")
    ResponseEntity getByUserId(@PathVariable final Long userId) {
        return userClient.getTeacherByUserId(userId);
    }
}
