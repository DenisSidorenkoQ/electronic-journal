package com.example.user.service;

import com.example.user.model.Teacher;
import com.example.user.model.User;
import com.example.user.repository.TeacherRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public Teacher save(final Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    public Optional<Teacher> getByUserId(final Long userId) {
        return teacherRepository.getByUserId(userId);
    }

    public Optional<Teacher> getById(final Long teacherId) {
        return teacherRepository.getById(teacherId);
    }

    public Optional<Teacher> getByFio(final String fio) {
        return teacherRepository.getByFio(fio);
    }
}
