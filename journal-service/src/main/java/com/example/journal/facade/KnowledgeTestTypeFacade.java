package com.example.journal.facade;

import com.example.journal.model.KnowledgeTestType;
import com.example.journal.service.KnowledgeTestTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KnowledgeTestTypeFacade {
    private final KnowledgeTestTypeService knowledgeTestTypeService;

    public KnowledgeTestType saveOrGet(KnowledgeTestType knowledgeTestType) {
        return knowledgeTestTypeService.getByName(knowledgeTestType.getName())
                .orElseGet(() -> knowledgeTestTypeService.save(knowledgeTestType));
    }
}
