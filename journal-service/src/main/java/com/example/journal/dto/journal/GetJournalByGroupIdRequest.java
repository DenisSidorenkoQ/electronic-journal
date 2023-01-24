package com.example.journal.dto.journal;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class GetJournalByGroupIdRequest {
    Long groupId;
}
