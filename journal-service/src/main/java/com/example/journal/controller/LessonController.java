package com.example.journal.controller;

import com.example.journal.converter.LessonConverter;
import com.example.journal.dto.lesson.LessonResponse;
import com.example.journal.dto.lesson.SaveLessonRequest;
import com.example.journal.facade.LessonFacade;
import com.example.journal.model.Lesson;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/lesson")
@RequiredArgsConstructor
public class LessonController {
    private final LessonFacade lessonFacade;
    private final LessonConverter converter;

    @PostMapping
    LessonResponse saveOrGet(@RequestBody SaveLessonRequest request) {
        Lesson lesson = converter.fromDto(request);

        return converter.toDto(lessonFacade.save(lesson));
    }
}
