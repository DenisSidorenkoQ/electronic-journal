package com.example.user.facade;

import com.example.user.model.Admin;
import com.example.user.model.Student;
import com.example.user.service.StudentService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StudentFacade {
    private final StudentService studentService;

    public Student saveOrGet(final Student student) {
        return studentService.getByUserId(student.getUserId())
                .orElseGet(() -> studentService.save(student));
    }

    public Optional<Student> getById(Long studentId) {
        return studentService.getById(studentId);
    }

    public Optional<Student> getByUserId(Long userId) {
        return studentService.getByUserId(userId);
    }
}
