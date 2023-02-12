package com.example.gateway.dto.subject;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class GetSubjectByNameRequest {
    String name;
}
