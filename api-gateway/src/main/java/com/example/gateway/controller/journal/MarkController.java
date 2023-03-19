package com.example.gateway.controller.journal;

import com.example.gateway.client.JournalClient;
import com.example.gateway.dto.mark.MarkResponse;
import com.example.gateway.dto.mark.SaveOrUpdateMarkRequest;
import com.example.gateway.dto.mark.SubjectAvgMarkResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@EnableMethodSecurity
public class MarkController {
    private final JournalClient journalClient;

    @PreAuthorize("hasRole('TEACHER')")
    @PostMapping("marks")
    MarkResponse upsert(@RequestBody @Validated SaveOrUpdateMarkRequest request) {
        return journalClient.upsertMark(request);
    }

    @PreAuthorize("hasRole('TEACHER') or hasRole('STUDENT')")
    @GetMapping("group/{groupId}/subject/{subjectId}/marks")
    List<MarkResponse> getMarksBySubjectIdAndGroupId(@PathVariable Long groupId, @PathVariable Long subjectId) {
        return journalClient.getMarksBySubjectIdAndGroupId(groupId, subjectId);
    }

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("student/{studentId}/subjects/marks/avg")
    List<SubjectAvgMarkResponse> getAvgStudentMarks(@PathVariable("studentId") Long studentId) {
        return journalClient.getAvgStudentMarks(studentId);
    }
}
