package com.example.journal.facade;

import com.example.journal.model.Lesson;
import com.example.journal.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LessonFacade {
    private final LessonService lessonService;

    public Lesson save(final Lesson lesson) {
        return lessonService.save(lesson);
    }
}
