package com.example.gateway.controller.journal;

import com.example.gateway.client.JournalClient;
import com.example.gateway.dto.lesson.GetLessonByGroupIdAndSubjectIdResponse;
import com.example.gateway.dto.lesson.LessonResponse;
import com.example.gateway.dto.lesson.SaveLessonRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@EnableMethodSecurity
public class LessonController {
    private final JournalClient journalClient;

    @PreAuthorize("hasRole('TEACHER')")
    @PostMapping("lessons")
    LessonResponse save(@RequestBody SaveLessonRequest request) {
        return journalClient.saveLesson(request);
    }

    @PreAuthorize("hasRole('TEACHER') or hasRole('STUDENT')")
    @GetMapping("lessons")
    List<GetLessonByGroupIdAndSubjectIdResponse> getAllLessonsByGroupIdAndSubjectId(
            @RequestParam final Long groupId,
            @RequestParam final Long subjectId
    ) {
        return journalClient.getAllLessonsByGroupIdAndSubjectId(groupId, subjectId);
    }
}
