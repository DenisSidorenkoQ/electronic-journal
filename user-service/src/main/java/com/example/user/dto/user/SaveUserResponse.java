package com.example.user.dto.user;

import lombok.Builder;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Builder
@Value
@Jacksonized
public class SaveUserResponse {
    String login;
    String password;
    Integer roleId;
}
