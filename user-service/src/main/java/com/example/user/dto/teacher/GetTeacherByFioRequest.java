package com.example.user.dto.teacher;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class GetTeacherByFioRequest {
    String fio;
}
