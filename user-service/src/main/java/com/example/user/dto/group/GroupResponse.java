package com.example.user.dto.group;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class GroupResponse {
    Long id;
    String name;
}
