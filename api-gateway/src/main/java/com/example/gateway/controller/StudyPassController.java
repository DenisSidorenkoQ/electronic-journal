package com.example.gateway.controller;

import com.example.gateway.client.JournalClient;
import com.example.gateway.dto.study_pass.StudyPassResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class StudyPassController {
    private final JournalClient journalClient;

    @GetMapping("group/{groupId}/subject/{subjectId}/pass")
    List<StudyPassResponse> getBySubjectIdAndGroupId(@PathVariable Long groupId, @PathVariable Long subjectId) {
        return journalClient.getBySubjectIdAndGroupId(groupId, subjectId);
    }
}
