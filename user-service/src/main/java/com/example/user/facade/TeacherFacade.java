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

    public Teacher save(final Teacher teacher) {
        return teacherService.getByUserId(teacher.getUserId())
                .orElseGet(() -> teacherService.save(teacher));
    }
}
