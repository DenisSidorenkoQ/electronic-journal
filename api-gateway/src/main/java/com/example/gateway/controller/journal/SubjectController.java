package com.example.gateway.controller.journal;

import com.example.gateway.client.JournalClient;
import com.example.gateway.dto.subject.*;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@EnableMethodSecurity
public class SubjectController {
    private final JournalClient journalClient;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("subjects")
    SubjectResponse saveOrGet(@RequestBody SaveSubjectRequest request) {
        return journalClient.saveOrGetSubject(request);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("subjects")
    List<SubjectResponse> getSubjectList() {
        return journalClient.getSubjectList();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("group/subjects")
    GroupHasSubjectResponse addSubjectToTheGroup(@RequestBody AddSubjectToTheGroupRequest request) {
        return journalClient.addSubjectToTheGroup(request);
    }

    @PreAuthorize("hasRole('STUDENT')")
    @GetMapping("group/{groupId}/subjects")
    List<SubjectResponse> getGroupSubjects(@PathVariable("groupId") Long groupId) {
        return journalClient.getGroupSubjects(groupId);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @GetMapping("teacher/{teacherId}/subjects")
    List<GroupHasSubjectResponse> getTeacherSubjects(@PathVariable("teacherId") Long teacherId) {
        return journalClient.getTeacherSubjects(teacherId);
    }

    @PreAuthorize("hasRole('TEACHER')")
    @GetMapping("teacher/{teacherId}/group/{groupId}/subjects")
    List<SubjectResponse> getSubjectsByTeacherIdAndGroupId(@PathVariable("teacherId") Long teacherId,
                                                           @PathVariable("groupId") Long groupId) {
        return journalClient.getSubjectsByTeacherIdAndGroupId(teacherId, groupId);
    }
}
