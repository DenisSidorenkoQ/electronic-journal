package com.example.gateway.controller;

import com.example.gateway.client.JournalClient;
import com.example.gateway.dto.mark.MarkResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MarkController {
    private final JournalClient journalClient;

    @GetMapping("lesson/{lessonId}/marks")
    List<MarkResponse> getMarkByLessonId(@PathVariable("lessonId") Long lessonId) {
        return journalClient.getMarkByLessonId(lessonId);
    }

    @GetMapping("group/{groupId}/subject/{subjectId}/marks")
    List<MarkResponse> getMarksBySubjectIdAndGroupId(@PathVariable Long groupId, @PathVariable Long subjectId) {
        return journalClient.getMarksBySubjectIdAndGroupId(groupId, subjectId);
    }
}
