package com.example.gateway.dto.mark;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class SaveOrUpdateMarkRequest {
    Long lessonId;
    Long studentId;
    @Min(1)
    @Max(10)
    Integer number;
}
