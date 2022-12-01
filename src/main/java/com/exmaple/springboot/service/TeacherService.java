package com.exmaple.springboot.service;

import com.exmaple.springboot.model.Teacher;
import com.exmaple.springboot.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeachers(int departmentId) {
        return teacherRepository.getTeachers(departmentId);
    }
}
