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

    public Optional<Teacher> save(final Teacher teacher) {
        return teacherService.save(teacher);
    }
}
