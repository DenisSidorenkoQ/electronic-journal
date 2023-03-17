package com.example.user.converter;

import com.example.user.dto.knowledge_test_type.KnowledgeTestTypeResponse;
import com.example.user.model.KnowledgeTestType;
import org.mapstruct.Mapper;

@Mapper
public interface KnowledgeTestTypeFacadeConverter {
    KnowledgeTestTypeResponse toDto(KnowledgeTestType knowledgeTestType);
}
