package com.example.user.dto.user;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class SaveUserResponse {
    Long id;
    String login;
    Integer roleId;
}
