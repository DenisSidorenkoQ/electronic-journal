package com.exmaple.springboot.controller;

import com.exmaple.springboot.converter.StudentConverter;
import com.exmaple.springboot.dto.StudentDto;
import com.exmaple.springboot.model.Mark;
import com.exmaple.springboot.model.Student;
import com.exmaple.springboot.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class StudentRestController {
    private final StudentService studentService;

    @GetMapping("/api/students/{groupId}")
    protected List<Student> getStudentsByGroupId(@PathVariable int groupId) {
        return studentService.getStudentsByGroupId(groupId);
    }

    @GetMapping("/api/students/{groupId}/{subjectId}")
    protected Map<Student, List<Mark>> getStudentsAndMarksByGroupId(@PathVariable int groupId,
                                                                       @PathVariable int subjectId) {
        return studentService.getStudentsAndMarksByGroupIdAndSubjectId(groupId, subjectId);
    }

}
