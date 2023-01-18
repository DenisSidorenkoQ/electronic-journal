package com.example.user.converter;

import com.example.user.dto.user.SaveUserRequest;
import com.example.user.dto.user.UserResponse;
import com.example.user.model.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserConverter {

    UserResponse toDto(final User user);

    User fromDto(final SaveUserRequest user);
}
