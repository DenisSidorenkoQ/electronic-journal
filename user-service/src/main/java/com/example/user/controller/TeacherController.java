package com.example.user.controller;

import com.example.user.converter.TeacherConverter;
import com.example.user.dto.teacher.GetTeacherByFioRequest;
import com.example.user.dto.teacher.SaveTeacherRequest;
import com.example.user.dto.teacher.TeacherResponse;
import com.example.user.facade.TeacherFacade;
import com.example.user.model.Student;
import com.example.user.model.Teacher;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TeacherController {
    private final TeacherFacade teacherFacade;
    private final TeacherConverter converter;

    @PostMapping("/teacher")
    TeacherResponse saveOrGet(@RequestBody SaveTeacherRequest request) {
        Teacher teacher = converter.fromDto(request);

        return converter.toDto(teacherFacade.saveOrGet(teacher));
    }

    @GetMapping("/teacher/{teacherId}")
    ResponseEntity getById(@PathVariable Long teacherId) {
        Optional<Teacher> findTeacher = teacherFacade.getById(teacherId);

        return findTeacher
                .map(value -> new ResponseEntity(converter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }

    @GetMapping("/user/{userId}/teacher")
    ResponseEntity getByUserId(@PathVariable final Long userId) {
        Optional<Teacher> teacher = teacherFacade.getByUserId(userId);

        return teacher
                .map(value -> new ResponseEntity(converter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }
}
