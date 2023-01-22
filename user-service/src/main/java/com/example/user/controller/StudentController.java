package com.example.user.controller;

import com.example.user.converter.StudentConverter;
import com.example.user.dto.admin.AdminResponse;
import com.example.user.dto.student.GetStudentByFioRequest;
import com.example.user.dto.student.SaveStudentRequest;
import com.example.user.dto.student.StudentResponse;
import com.example.user.facade.StudentFacade;
import com.example.user.model.Student;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentConverter converter;
    private final StudentFacade studentFacade;

    @PostMapping
    StudentResponse saveOrGet(@RequestBody SaveStudentRequest request) {
        Student student = converter.fromDto(request);

        return converter.toDto(studentFacade.saveOrGet(student));
    }

    @GetMapping
    ResponseEntity getByFio(@RequestBody GetStudentByFioRequest request) {
        Optional<Student> findStudent = studentFacade.getByFio(request.getFio());

        return findStudent
                .map(value -> new ResponseEntity(converter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }

    @GetMapping("{studentId}")
    ResponseEntity getById(@PathVariable Long studentId) {
        Optional<Student> findStudent = studentFacade.getById(studentId);

        return findStudent
                .map(value -> new ResponseEntity(converter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }
}
