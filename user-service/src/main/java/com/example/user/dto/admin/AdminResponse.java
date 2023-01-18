package com.example.user.dto.admin;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class AdminResponse {
    Long id;
    Long userId;
    String fio;
}
