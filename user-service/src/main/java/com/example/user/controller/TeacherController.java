package com.example.user.controller;

import com.example.user.converter.TeacherConverter;
import com.example.user.dto.admin.SaveAdminRequest;
import com.example.user.dto.teacher.SaveTeacherRequest;
import com.example.user.dto.teacher.TeacherResponse;
import com.example.user.facade.TeacherFacade;
import com.example.user.model.Teacher;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherFacade teacherFacade;
    private final TeacherConverter converter;

    @PostMapping
    ResponseEntity save(@RequestBody SaveTeacherRequest request) {
        Teacher teacher = converter.fromDto(request);

        Optional<Teacher> savedTeacher = teacherFacade.save(teacher);

        return savedTeacher
                .map(value -> new ResponseEntity(converter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }
}
