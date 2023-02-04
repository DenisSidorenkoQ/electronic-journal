package com.example.user.converter;

import com.example.user.dto.user.GetUserByCredentialsRequest;
import com.example.user.dto.user.SaveUserRequest;
import com.example.user.dto.user.SaveUserResponse;
import com.example.user.dto.user.UserResponse;
import com.example.user.model.User;
import com.example.user.model.UserAndRole;
import org.mapstruct.Mapper;

@Mapper
public interface UserConverter {

    UserResponse toDto(final UserAndRole user);
    SaveUserResponse toDto(final User user);

    User fromDto(final SaveUserRequest user);

    User fromDto(final GetUserByCredentialsRequest request);
}
