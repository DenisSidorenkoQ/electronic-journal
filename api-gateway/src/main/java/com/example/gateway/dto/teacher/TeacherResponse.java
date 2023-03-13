package com.example.gateway.dto.teacher;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class TeacherResponse {
    Long id;
    Long userId;
    Long departmentId;
    String fio;
}
