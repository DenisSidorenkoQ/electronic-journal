package com.example.user.dto.student;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class GetStudentByFioRequest {
    String fio;
}
