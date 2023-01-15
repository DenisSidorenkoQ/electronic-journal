package com.example.user.dto.admin;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class GetAdminByUserIdRequest {
    Long userId;
}
