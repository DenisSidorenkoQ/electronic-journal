package com.example.journal.facade;

import com.example.journal.model.KnowledgeTestType;
import com.example.journal.service.KnowledgeTestTypeService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KnowledgeTestTypeFacade {
    private final KnowledgeTestTypeService knowledgeTestTypeService;

    public KnowledgeTestType saveOrGet(final KnowledgeTestType knowledgeTestType) {
        return knowledgeTestTypeService.getByName(knowledgeTestType.getName())
                .orElseGet(() -> knowledgeTestTypeService.save(knowledgeTestType));
    }

    public Optional<KnowledgeTestType> getById(final Long testId) {
        return knowledgeTestTypeService.getById(testId);
    }

    public Optional<KnowledgeTestType> getByName(final String name) {
        return knowledgeTestTypeService.getByName(name);
    }
}
