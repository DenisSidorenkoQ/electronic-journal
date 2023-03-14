package com.example.gateway.controller;

import com.example.gateway.client.JournalClient;
import com.example.gateway.dto.mark.MarkResponse;
import com.example.gateway.dto.mark.SaveOrUpdateMarkRequest;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MarkController {
    private final JournalClient journalClient;

    @PostMapping("marks")
    MarkResponse upsert(@RequestBody @Validated SaveOrUpdateMarkRequest request) {
        return journalClient.upsertMark(request);
    }

    @GetMapping("lesson/{lessonId}/marks")
    List<MarkResponse> getMarkByLessonId(@PathVariable("lessonId") Long lessonId) {
        return journalClient.getMarkByLessonId(lessonId);
    }

    @GetMapping("group/{groupId}/subject/{subjectId}/marks")
    List<MarkResponse> getMarksBySubjectIdAndGroupId(@PathVariable Long groupId, @PathVariable Long subjectId) {
        return journalClient.getMarksBySubjectIdAndGroupId(groupId, subjectId);
    }
}
