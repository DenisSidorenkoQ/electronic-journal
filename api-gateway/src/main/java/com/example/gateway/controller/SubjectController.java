package com.example.gateway.controller;

import com.example.gateway.client.JournalClient;
import com.example.gateway.dto.subject.*;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SubjectController {
    private final JournalClient journalClient;

    @PostMapping("subject")
    SubjectResponse saveOrGet(@RequestBody SaveSubjectRequest request) {
        return journalClient.saveOrGetSubject(request);
    }

    @GetMapping("subject/{subjectId}")
    ResponseEntity getById(@PathVariable("subjectId") final Long subjectId) {
        return journalClient.getSubjectById(subjectId);
    }

    @GetMapping("subject")
    ResponseEntity getByName(@RequestBody final GetSubjectByNameRequest request) {
        return journalClient.getSubjectByName(request);
    }

    @PostMapping("group/subject")
    GroupHasSubjectResponse addSubjectToTheGroup(@RequestBody AddSubjectToTheGroupRequest request) {
        return journalClient.addSubjectToTheGroup(request);
    }

    @GetMapping("group/{groupId}/subjects")
    List<SubjectResponse> getGroupSubjects(@PathVariable("groupId") Long groupId) {
        return journalClient.getGroupSubjects(groupId);
    }

    @GetMapping("teacher/{teacherId}/subjects")
    List<GroupHasSubjectResponse> getTeacherSubjects(@PathVariable("teacherId") Long teacherId) {
        return journalClient.getTeacherSubjects(teacherId);
    }

    @GetMapping("teacher/{teacherId}/group/{groupId}/subjects")
    List<SubjectResponse> getSubjectsByTeacherIdAndGroupId(@PathVariable("teacherId") Long teacherId,
                                                           @PathVariable("groupId") Long groupId) {
        return journalClient.getSubjectsByTeacherIdAndGroupId(teacherId, groupId);
    }
}
