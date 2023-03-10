package com.example.gateway.dto.lesson;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class SaveLessonRequest {
    Long journalId;
    Long subjectId;
    String themeName;
    Long dateTimestamp;
}
