package com.example.gateway.controller;

import com.example.gateway.client.JournalClient;
import com.example.gateway.dto.lesson.GetLessonByGroupIdAndSubjectIdResponse;
import com.example.gateway.dto.lesson.LessonResponse;
import com.example.gateway.dto.lesson.SaveLessonRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class LessonController {
    private final JournalClient journalClient;

    @PostMapping("lesson")
    LessonResponse save(@RequestBody SaveLessonRequest request) {
        return journalClient.saveLesson(request);
    }

    @GetMapping("lesson/{lessonId}")
    ResponseEntity getById(@PathVariable final Long lessonId) {
        return journalClient.getLessonById(lessonId);
    }

    @GetMapping("lessons")
    List<GetLessonByGroupIdAndSubjectIdResponse> getAllLessonsByGroupIdAndSubjectId(
            @RequestParam final Long groupId,
            @RequestParam final Long subjectId
    ) {
        return journalClient.getAllLessonsByGroupIdAndSubjectId(groupId, subjectId);
    }
}
