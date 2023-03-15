package com.example.user.dto.role;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class RoleResponse {
    Long id;
    String name;
}
