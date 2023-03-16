package com.example.gateway.dto.role;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class SaveRoleRequest {
    String name;
}
