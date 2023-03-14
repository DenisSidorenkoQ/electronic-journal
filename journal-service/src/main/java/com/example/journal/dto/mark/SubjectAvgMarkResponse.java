package com.example.journal.dto.mark;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class SubjectAvgMarkResponse {
    Long subjectId;
    String subjectName;
    Long timeToStudy;
    String knowledgeTestType;
    Double avgMark;
}
