package com.example.journal.controller;

import com.example.journal.converter.KnowledgeTestTypeConverter;
import com.example.journal.dto.knowledge_test_type.GetKnowledgeTestTypeByNameRequest;
import com.example.journal.dto.knowledge_test_type.KnowledgeTestTypeResponse;
import com.example.journal.dto.knowledge_test_type.SaveKnowledgeTestTypeRequest;
import com.example.journal.facade.KnowledgeTestTypeFacade;
import com.example.journal.model.KnowledgeTestType;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/knowledge-test")
@RequiredArgsConstructor
public class KnowledgeTestTypeController {
    private final KnowledgeTestTypeConverter converter;
    private final KnowledgeTestTypeFacade knowledgeTestTypeFacade;

    @PostMapping
    KnowledgeTestTypeResponse saveOrGet(@RequestBody SaveKnowledgeTestTypeRequest request) {
        KnowledgeTestType knowledgeTestType = converter.fromDto(request);

        return converter.toDto(knowledgeTestTypeFacade.saveOrGet(knowledgeTestType));
    }

    @GetMapping("{testId}")
    ResponseEntity getById(@PathVariable("testId") final Long testId) {
        Optional<KnowledgeTestType> knowledgeTestType = knowledgeTestTypeFacade.getById(testId);

        return knowledgeTestType
                .map(value -> new ResponseEntity(converter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }

    @GetMapping
    ResponseEntity getAdminById(@RequestBody final GetKnowledgeTestTypeByNameRequest request) {
        Optional<KnowledgeTestType> knowledgeTestType = knowledgeTestTypeFacade.getByName(request.getName());

        return knowledgeTestType
                .map(value -> new ResponseEntity(converter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }
}
