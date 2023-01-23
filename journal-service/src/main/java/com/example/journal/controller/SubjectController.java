package com.example.journal.controller;

import com.example.journal.converter.GroupHasSubjectConverter;
import com.example.journal.converter.SubjectConverter;
import com.example.journal.dto.subject.*;
import com.example.journal.facade.SubjectFacade;
import com.example.journal.model.GroupHasSubject;
import com.example.journal.model.Subject;
import com.example.journal.model.SubjectByGroupInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/subject")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectConverter subjectConverter;
    private final GroupHasSubjectConverter groupHasSubjectConverter;
    private final SubjectFacade subjectFacade;

    @PostMapping
    SubjectResponse saveOrGet(@RequestBody SaveSubjectRequest request) {
        Subject subject = subjectConverter.fromDto(request);

        return subjectConverter.toDto(subjectFacade.saveOrGetSubject(subject));
    }

    @GetMapping("{subjectId}")
    ResponseEntity getById(@PathVariable("subjectId") final Long subjectId) {
        Optional<Subject> subject = subjectFacade.getById(subjectId);

        return subject
                .map(value -> new ResponseEntity(subjectConverter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }

    @GetMapping
    ResponseEntity getByName(@RequestBody final GetSubjectByNameRequest request) {
        Optional<Subject> subject = subjectFacade.getByName(request.getName());

        return subject
                .map(value -> new ResponseEntity(subjectConverter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }

    @PostMapping("group")
    GroupHasSubjectResponse addSubjectToTheGroup(@RequestBody AddSubjectToTheGroupRequest request) {
        GroupHasSubject groupHasSubject = groupHasSubjectConverter.fromDto(request);

        return groupHasSubjectConverter.toDto(subjectFacade.addSubjectToTheGroup(groupHasSubject));
    }

    @GetMapping("group/{groupId}")
    List<SubjectByGroupInfoResponse> getGroupSubjects(@PathVariable("groupId") Long groupId) {
        List<SubjectByGroupInfo> subjectByGroupInfos = subjectFacade.getGroupSubjects(groupId);
        List<SubjectByGroupInfoResponse> subjectByGroupInfoResponse = new ArrayList<>();

        subjectByGroupInfos.forEach((subject) -> subjectByGroupInfoResponse.add(subjectConverter.toDto(subject)));

        return subjectByGroupInfoResponse;
    }
}
