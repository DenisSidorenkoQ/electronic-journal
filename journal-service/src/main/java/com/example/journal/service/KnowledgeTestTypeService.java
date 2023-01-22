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

    public Optional<KnowledgeTestType> getByName(String name) {
        return knowledgeTestTypeRepository.getByName(name);
    }

    public KnowledgeTestType save(KnowledgeTestType knowledgeTestType) {
        return knowledgeTestTypeRepository.save(knowledgeTestType.getName());
    }
}
