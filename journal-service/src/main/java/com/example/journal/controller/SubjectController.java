package com.example.journal.controller;

import com.example.journal.converter.SubjectConverter;
import com.example.journal.dto.subject.GetSubjectByNameRequest;
import com.example.journal.dto.subject.SaveSubjectRequest;
import com.example.journal.dto.subject.SubjectResponse;
import com.example.journal.facade.SubjectFacade;
import com.example.journal.model.KnowledgeTestType;
import com.example.journal.model.Subject;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/subject")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectConverter converter;
    private final SubjectFacade subjectFacade;

    @PostMapping
    SubjectResponse saveOrGet(@RequestBody SaveSubjectRequest request) {
        Subject subject = converter.fromDto(request);

        return converter.toDto(subjectFacade.saveOrGet(subject));
    }

    @GetMapping("{subjectId}")
    ResponseEntity getById(@PathVariable("subjectId") final Long subjectId) {
        Optional<Subject> subject = subjectFacade.getById(subjectId);

        return subject
                .map(value -> new ResponseEntity(converter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }

    @GetMapping
    ResponseEntity getByName(@RequestBody final GetSubjectByNameRequest request) {
        Optional<Subject> subject = subjectFacade.getByName(request.getName());

        return subject
                .map(value -> new ResponseEntity(converter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }
}
