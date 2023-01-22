package com.example.journal.controller;

import com.example.journal.converter.KnowledgeTestTypeConverter;
import com.example.journal.dto.knowledge_test_type.KnowledgeTestTypeResponse;
import com.example.journal.dto.knowledge_test_type.SaveKnowledgeTestTypeRequest;
import com.example.journal.facade.KnowledgeTestTypeFacade;
import com.example.journal.model.KnowledgeTestType;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
