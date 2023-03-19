package com.example.gateway.controller.user;

import com.example.gateway.client.UserClient;
import com.example.gateway.dto.student.SaveStudentRequest;
import com.example.gateway.dto.student.StudentResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@EnableMethodSecurity
public class StudentController {
    private final UserClient userClient;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/students")
    StudentResponse saveOrGet(@RequestBody SaveStudentRequest request) {
        return userClient.saveOrGetStudent(request);
    }

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("/user/{userId}/students")
    ResponseEntity<StudentResponse> getByUserId(@PathVariable final Long userId) {
        return userClient.getStudentByUserId(userId);
    }

    @PreAuthorize("hasRole('STUDENT') or hasRole('TEACHER')")
    @GetMapping("/group/{groupId}/students")
    List<StudentResponse> getAllStudentsByGroup(@PathVariable Long groupId) {
        return userClient.getAllStudentsByGroup(groupId);
    }
}
