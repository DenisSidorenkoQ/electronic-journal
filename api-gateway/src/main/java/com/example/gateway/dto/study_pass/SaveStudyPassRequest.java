package com.example.gateway.dto.study_pass;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class SaveStudyPassRequest {
    Long lessonId;
    Long studentId;
    Boolean pass;
}
