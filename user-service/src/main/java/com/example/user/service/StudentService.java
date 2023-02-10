package com.example.user.service;

import com.example.user.model.Student;
import com.example.user.repository.StudentRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public Student save(final Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> getById(final Long studentId) {
        return studentRepository.getById(studentId);
    }

    public Optional<Student> getByUserId(final Long userId) {
        return studentRepository.getByUserId(userId);
    }
}
