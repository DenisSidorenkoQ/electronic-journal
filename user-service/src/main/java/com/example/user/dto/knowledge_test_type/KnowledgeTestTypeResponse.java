package com.example.user.dto.knowledge_test_type;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class KnowledgeTestTypeResponse {
    Long id;
    String name;
}
