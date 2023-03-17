package com.example.user.controller;

import com.example.user.converter.KnowledgeTestTypeFacadeConverter;
import com.example.user.dto.knowledge_test_type.KnowledgeTestTypeResponse;
import com.example.user.facade.KnowledgeTestTypeFacade;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class KnowledgeTestTypeController {
    private final KnowledgeTestTypeFacade knowledgeTestTypeFacade;
    private final KnowledgeTestTypeFacadeConverter converter;

    @GetMapping("/test-type")
    List<KnowledgeTestTypeResponse> getKnowledgeTestTypeList() {
        return knowledgeTestTypeFacade.getKnowledgeTestTypeList().stream().map(converter::toDto).collect(Collectors.toList());
    }
}
