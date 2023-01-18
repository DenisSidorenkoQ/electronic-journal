package com.example.user.controller;

import com.example.user.converter.TeacherConverter;
import com.example.user.dto.teacher.SaveTeacherRequest;
import com.example.user.dto.teacher.TeacherResponse;
import com.example.user.facade.TeacherFacade;
import com.example.user.model.Teacher;
import lombok.RequiredArgsConstructor;
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
    TeacherResponse save(@RequestBody SaveTeacherRequest request) {
        Teacher teacher = converter.fromDto(request);

        return converter.toDto(teacherFacade.save(teacher));
    }
}
