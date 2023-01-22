package com.example.journal.converter;

import com.example.journal.dto.knowledge_test_type.KnowledgeTestTypeResponse;
import com.example.journal.dto.knowledge_test_type.SaveKnowledgeTestTypeRequest;
import com.example.journal.model.KnowledgeTestType;
import org.mapstruct.Mapper;

@Mapper
public interface KnowledgeTestTypeConverter {
    KnowledgeTestTypeResponse toDto(final KnowledgeTestType department);

    KnowledgeTestType fromDto(final SaveKnowledgeTestTypeRequest request);
}
