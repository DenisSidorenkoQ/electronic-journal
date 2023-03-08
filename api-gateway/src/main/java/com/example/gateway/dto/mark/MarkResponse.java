package com.example.gateway.dto.mark;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class MarkResponse {
    Long id;
    Long lessonId;
    Long studentId;
    Integer number;
}
