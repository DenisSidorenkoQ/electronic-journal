package com.example.gateway.controller;

import com.example.gateway.client.JournalClient;
import com.example.gateway.dto.study_pass.SaveStudyPassRequest;
import com.example.gateway.dto.study_pass.StudyPassResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StudyPassController {
    private final JournalClient journalClient;

    @PostMapping("study-pass")
    StudyPassResponse upsert(@RequestBody SaveStudyPassRequest request) {
        return journalClient.upsertStudyPass(request);
    }

    @GetMapping("group/{groupId}/subject/{subjectId}/pass")
    List<StudyPassResponse> getBySubjectIdAndGroupId(@PathVariable Long groupId, @PathVariable Long subjectId) {
        return journalClient.getBySubjectIdAndGroupId(groupId, subjectId);
    }
}
