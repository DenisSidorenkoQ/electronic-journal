package com.example.user.controller;

import com.example.user.converter.StudentConverter;
import com.example.user.dto.student.SaveStudentRequest;
import com.example.user.dto.student.StudentResponse;
import com.example.user.facade.StudentFacade;
import com.example.user.model.Student;
import java.util.ArrayList;
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
public class StudentController {
    private final StudentConverter converter;
    private final StudentFacade studentFacade;

    @PostMapping("/students")
    StudentResponse saveOrGet(@RequestBody SaveStudentRequest request) {
        Student student = converter.fromDto(request);

        return converter.toDto(studentFacade.saveOrGet(student));
    }

    @GetMapping("/user/{userId}/students")
    ResponseEntity getByUserId(@PathVariable final Long userId) {
        Optional<Student> student = studentFacade.getByUserId(userId);

        return student
                .map(value -> new ResponseEntity(converter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }

    @GetMapping("/student/{studentId}")
    ResponseEntity getById(@PathVariable Long studentId) {
        Optional<Student> findStudent = studentFacade.getById(studentId);

        return findStudent
                .map(value -> new ResponseEntity(converter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }

    @GetMapping("/group/{groupId}/students")
    List<StudentResponse> getAllStudentsByGroup(@PathVariable Long groupId) {
        List<Student> studentList = studentFacade.getAllStudentsByGroup(groupId);

        if (studentList.size() > 0) {
            return studentList.stream().map(converter::toDto).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
