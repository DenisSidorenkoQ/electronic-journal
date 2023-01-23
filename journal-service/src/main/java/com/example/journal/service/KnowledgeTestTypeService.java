package com.example.journal.service;

import com.example.journal.model.KnowledgeTestType;
import com.example.journal.repository.KnowledgeTestTypeRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KnowledgeTestTypeService {
    private final KnowledgeTestTypeRepository knowledgeTestTypeRepository;

    public Optional<KnowledgeTestType> getByName(final String name) {
        return knowledgeTestTypeRepository.getByName(name);
    }

    public KnowledgeTestType save(final KnowledgeTestType knowledgeTestType) {
        return knowledgeTestTypeRepository.save(knowledgeTestType);
    }

    public Optional<KnowledgeTestType> getById(final Long testId) {
        return knowledgeTestTypeRepository.getById(testId);
    }
}
