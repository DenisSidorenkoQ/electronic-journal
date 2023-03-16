package com.example.gateway.dto.admin;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class GetAdminByUserIdRequest {
    Long userId;
}
