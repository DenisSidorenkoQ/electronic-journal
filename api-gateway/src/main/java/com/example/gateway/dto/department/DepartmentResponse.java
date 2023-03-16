package com.example.gateway.dto.department;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class DepartmentResponse {
    Long id;
    String name;
}
