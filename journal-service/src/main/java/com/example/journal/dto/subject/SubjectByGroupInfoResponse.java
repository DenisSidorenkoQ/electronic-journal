package com.example.journal.dto.subject;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class SubjectByGroupInfoResponse {
    Long id;
    String subjectName;
    Long timeToStudy;
    String knowledgeTestTypeName;
    String teacherFio;
}
