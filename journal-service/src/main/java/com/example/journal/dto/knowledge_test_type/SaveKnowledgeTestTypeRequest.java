package com.example.journal.dto.knowledge_test_type;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class SaveKnowledgeTestTypeRequest {
    String name;
}
