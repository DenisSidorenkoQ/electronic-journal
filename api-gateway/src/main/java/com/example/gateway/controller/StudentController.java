package com.example.gateway.controller;

import com.example.gateway.client.UserClient;
import com.example.gateway.dto.student.SaveStudentRequest;
import com.example.gateway.dto.student.StudentResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StudentController {
    private final UserClient userClient;

    @PostMapping("/student")
    StudentResponse saveOrGet(@RequestBody SaveStudentRequest request) {
        return userClient.saveOrGetStudent(request);
    }

    @GetMapping("/user/{userId}/student")
    ResponseEntity<StudentResponse> getByUserId(@PathVariable final Long userId) {
        return userClient.getStudentByUserId(userId);
    }

    @GetMapping("/student/{studentId}")
    ResponseEntity<StudentResponse> getById(@PathVariable Long studentId) {
        return userClient.getStudentById(studentId);
    }

    @GetMapping("/group/{groupId}/students")
    List<StudentResponse> getAllStudentsByGroup(@PathVariable Long groupId) {
        return userClient.getAllStudentsByGroup(groupId);
    }
}
