package com.example.user.facade;

import com.example.user.converter.UserConverter;
import com.example.user.dto.SaveUserRequest;
import com.example.user.model.User;
import com.example.user.service.UserService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserService userService;
    private final UserConverter converter;

    public Optional<User> save(final SaveUserRequest request) {
        Optional<User> findUser = userService.getUserByLogin(request.getLogin());

        if (findUser.isEmpty()) {
            User user = converter.fromDto(request);
            User savedUser = userService.save(user);

            return Optional.of(savedUser);
        }
        return Optional.empty();
    }

    public User getUserById(final Long userId) {
        return userService.getUserById(userId);
    }

    public Optional<User> getUserByLogin(final String login) {
        return userService.getUserByLogin(login);
    }
}
