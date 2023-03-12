package com.example.journal.service;

import com.example.journal.model.Lesson;
import com.example.journal.repository.LessonRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;

    public Optional<Lesson> getById(final Long lessonId) {
        return lessonRepository.getById(lessonId);
    }

    public List<Lesson> getAllLessonsByGroupIdAndSubjectId(final Long groupId, final Long subjectId) {
        return lessonRepository.getAllLessonsByGroupIdAndSubjectId(groupId, subjectId);
    }

    public Lesson save(Lesson lesson) {
        return lessonRepository.save(lesson);
    }
}
