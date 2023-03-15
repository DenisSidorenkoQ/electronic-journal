package com.example.journal.controller;

import com.example.journal.converter.LessonConverter;
import com.example.journal.dto.lesson.GetLessonByGroupIdAndSubjectIdResponse;
import com.example.journal.dto.lesson.LessonResponse;
import com.example.journal.dto.lesson.SaveLessonRequest;
import com.example.journal.facade.LessonFacade;
import com.example.journal.model.Lesson;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LessonController {
    private final LessonFacade lessonFacade;
    private final LessonConverter converter;

    @PostMapping("lessons")
    LessonResponse save(@RequestBody SaveLessonRequest request) {
        Lesson lesson = converter.fromDto(request);

        return converter.toDto(lessonFacade.save(lesson));
    }

    @GetMapping("lesson/{lessonId}")
    ResponseEntity getById(@PathVariable final Long lessonId) {
        Optional<Lesson> lesson = lessonFacade.getById(lessonId);

        return lesson
                .map(value -> new ResponseEntity(converter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }

    @GetMapping("lessons")
    List<GetLessonByGroupIdAndSubjectIdResponse> getAllLessonsByGroupIdAndSubjectId(
            @RequestParam final Long groupId,
            @RequestParam final Long subjectId
    ) {
        List<Lesson> lessons = lessonFacade.getAllLessonsByGroupIdAndSubjectId(groupId, subjectId);
        List<GetLessonByGroupIdAndSubjectIdResponse> response = new ArrayList<>();

        lessons.stream()
                .sorted(Comparator.comparingLong((Lesson::getDateTimestamp)))
                .forEach(lesson -> {
                    response.add(GetLessonByGroupIdAndSubjectIdResponse
                            .builder()
                            .id(lesson.getId())
                            .themeName(lesson.getThemeName())
                            .dateTimestamp(lesson.getDateTimestamp())
                            .build());
                });

        return response;
    }
}
