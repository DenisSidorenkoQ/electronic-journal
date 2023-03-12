package com.example.journal.controller;

import com.example.journal.converter.GroupHasSubjectConverter;
import com.example.journal.converter.SubjectConverter;
import com.example.journal.dto.subject.*;
import com.example.journal.facade.SubjectFacade;
import com.example.journal.model.GroupHasSubject;
import com.example.journal.model.Subject;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectConverter subjectConverter;
    private final GroupHasSubjectConverter groupHasSubjectConverter;
    private final SubjectFacade subjectFacade;

    @PostMapping("subject")
    SubjectResponse saveOrGet(@RequestBody SaveSubjectRequest request) {
        Subject subject = subjectConverter.fromDto(request);

        return subjectConverter.toDto(subjectFacade.saveOrGetSubject(subject));
    }

    @GetMapping("subject/{subjectId}")
    ResponseEntity getById(@PathVariable("subjectId") final Long subjectId) {
        Optional<Subject> subject = subjectFacade.getById(subjectId);

        return subject
                .map(value -> new ResponseEntity(subjectConverter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }

    @GetMapping("subject")
    ResponseEntity getByName(@RequestBody final GetSubjectByNameRequest request) {
        Optional<Subject> subject = subjectFacade.getByName(request.getName());

        return subject
                .map(value -> new ResponseEntity(subjectConverter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }

    @PostMapping("group/subject")
    GroupHasSubjectResponse addSubjectToTheGroup(@RequestBody AddSubjectToTheGroupRequest request) {
        GroupHasSubject groupHasSubject = groupHasSubjectConverter.fromDto(request);

        return groupHasSubjectConverter.toDto(subjectFacade.addSubjectToTheGroup(groupHasSubject));
    }

    @GetMapping("group/{groupId}/subjects")
    List<SubjectResponse> getGroupSubjects(@PathVariable("groupId") Long groupId) {
        List<Subject> subjectByGroupInfos = subjectFacade.getGroupSubjects(groupId);

        return subjectByGroupInfos.stream().map(subjectConverter::toDto).collect(Collectors.toList());
    }

    @GetMapping("teacher/{teacherId}/subjects")
    List<GroupHasSubjectResponse> getTeacherSubjects(@PathVariable("teacherId") Long teacherId) {
        List<GroupHasSubject> subjectByTeacherInfos = subjectFacade.getTeacherSubjects(teacherId);

        return subjectByTeacherInfos.stream().map(subjectConverter::toDto).collect(Collectors.toList());
    }

    @GetMapping("teacher/{teacherId}/group/{groupId}/subjects")
    List<SubjectResponse> getSubjectsByTeacherIdAndGroupId(@PathVariable Long teacherId, @PathVariable Long groupId) {
        List<Subject> foundSubjects = subjectFacade.getSubjectsByTeacherIdAndGroupId(teacherId, groupId);

        return foundSubjects.stream().map(subjectConverter::toDto).collect(Collectors.toList());
    }
}
