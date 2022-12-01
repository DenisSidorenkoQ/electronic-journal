package com.exmaple.springboot.controller;

import com.exmaple.springboot.model.Teacher;
import com.exmaple.springboot.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeacherRestController {
    private final TeacherService teacherService;

    @GetMapping("/api/teacher/{departmentId}")
    protected List<Teacher> getStudentsByGroupId(@PathVariable int departmentId) {
        return teacherService.getTeachers(departmentId);
    }
}
