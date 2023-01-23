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
        return studentRepository.save(student.getUserId(), student.getGroupId(), student.getFio(), student.getSex());
    }

    public Optional<Student> getByFio(String fio) {
        return studentRepository.getByFio(fio);
    }

    public Optional<Student> getById(Long studentId) {
        return studentRepository.getById(studentId);
    }
}
