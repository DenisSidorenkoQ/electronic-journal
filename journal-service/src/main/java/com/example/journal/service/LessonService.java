package com.example.journal.service;

import com.example.journal.model.Lesson;
import com.example.journal.repository.LessonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LessonService {
    private final LessonRepository lessonRepository;

    public Lesson save(final Lesson lesson) {
        return lessonRepository.save(lesson);
    }
}
