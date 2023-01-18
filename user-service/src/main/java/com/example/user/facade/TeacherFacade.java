package com.example.user.facade;

import com.example.user.model.Teacher;
import com.example.user.service.TeacherService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TeacherFacade {
    private final TeacherService teacherService;

    public Teacher saveOrGet(final Teacher teacher) {
        return teacherService.getByUserId(teacher.getUserId())
                .orElseGet(() -> teacherService.save(teacher));
    }

    public Optional<Teacher> getById(final Long teacherId) {
        return teacherService.getById(teacherId);
    }

    public Optional<Teacher> getByFio(final String fio) {
        return teacherService.getByFio(fio);
    }
}
