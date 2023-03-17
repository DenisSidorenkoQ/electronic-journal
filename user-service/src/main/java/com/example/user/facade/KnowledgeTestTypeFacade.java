package com.example.user.facade;

import com.example.user.model.KnowledgeTestType;
import com.example.user.service.KnowledgeTestTypeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KnowledgeTestTypeFacade {
    private final KnowledgeTestTypeService knowledgeTestTypeService;

    public List<KnowledgeTestType> getKnowledgeTestTypeList() {
        return knowledgeTestTypeService.getKnowledgeTestTypeList();
    }
}
