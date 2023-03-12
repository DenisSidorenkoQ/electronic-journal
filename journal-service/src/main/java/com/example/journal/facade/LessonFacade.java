package com.example.journal.facade;

import com.example.journal.model.Lesson;
import com.example.journal.service.LessonService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LessonFacade {
    private final LessonService lessonService;

    public Optional<Lesson> getById(final Long lessonId) {
        return lessonService.getById(lessonId);
    }

    public List<Lesson> getAllLessonsByGroupIdAndSubjectId(final Long groupId, final Long subjectId) {
        return lessonService.getAllLessonsByGroupIdAndSubjectId(groupId, subjectId);
    }

    public Lesson save(Lesson lesson) {
        return lessonService.save(lesson);
    }
}
