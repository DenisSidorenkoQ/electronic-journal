package com.example.gateway.controller.journal;

import com.example.gateway.client.JournalClient;
import com.example.gateway.dto.study_pass.SaveStudyPassRequest;
import com.example.gateway.dto.study_pass.StudyPassResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@EnableMethodSecurity
public class StudyPassController {
    private final JournalClient journalClient;

    @PreAuthorize("hasRole('TEACHER')")
    @PostMapping("study-pass")
    StudyPassResponse upsert(@RequestBody SaveStudyPassRequest request) {
        return journalClient.upsertStudyPass(request);
    }

    @PreAuthorize("hasRole('TEACHER') or hasRole('STUDENT')")
    @GetMapping("group/{groupId}/subject/{subjectId}/pass")
    List<StudyPassResponse> getBySubjectIdAndGroupId(@PathVariable Long groupId, @PathVariable Long subjectId) {
        return journalClient.getBySubjectIdAndGroupId(groupId, subjectId);
    }
}
