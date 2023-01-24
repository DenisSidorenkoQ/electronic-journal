package com.example.journal.dto.lesson;

import java.sql.Timestamp;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class LessonResponse {
    Long id;
    Long journalId;
    Long subjectId;
    String themeName;
    Long dateTimestamp;
}
