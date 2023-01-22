package com.example.journal.dto.subject;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class SubjectResponse {
    Long id;
    String name;
    Long knowledgeTestTypeId;
}
