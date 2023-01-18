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
        return teacherRepository.save(teacher.getUserId(), teacher.getDepartmentId(), teacher.getFio());
    }

    public Optional<Teacher> getByUserId(final Long userId) {
        return teacherRepository.getByUserId(userId);
    }
}
