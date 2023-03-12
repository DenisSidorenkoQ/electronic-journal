package com.example.gateway.dto.journal;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class JournalResponse {
    Long id;
    Long groupId;
}
