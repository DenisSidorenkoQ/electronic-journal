package com.example.user.facade;

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
        return studentService.getByFio(student.getFio())
                .orElseGet(() -> studentService.save(student));
    }

    public Optional<Student> getByFio(String fio) {
        return studentService.getByFio(fio);
    }

    public Optional<Student> getById(Long studentId) {
        return studentService.getById(studentId);
    }
}
