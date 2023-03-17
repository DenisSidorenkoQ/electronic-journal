package com.example.gateway.dto.group;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class SaveGroupRequest {
    String name;
}
