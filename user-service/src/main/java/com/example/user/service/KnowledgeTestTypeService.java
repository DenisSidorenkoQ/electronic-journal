package com.example.user.service;

import com.example.user.model.KnowledgeTestType;
import com.example.user.repository.KnowledgeTestTypeRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KnowledgeTestTypeService {
    private final KnowledgeTestTypeRepository repository;

    public List<KnowledgeTestType> getKnowledgeTestTypeList() {
        return repository.getKnowledgeTestTypeList();
    }
}
