package com.example.user.facade;

import com.example.user.model.User;
import com.example.user.service.UserService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserService userService;

    public Optional<User> save(final User user) {
        Optional<User> findUser = userService.getUserByLogin(user.getLogin());

        if (findUser.isEmpty()) {
            User savedUser = userService.save(user);

            return Optional.of(savedUser);
        }
        return Optional.empty();
    }

    public Optional<User> getById(final Long userId) {
        return userService.getUserById(userId);
    }

    public Optional<User> getByLogin(final String login) {
        return userService.getUserByLogin(login);
    }

    public Optional<User> getByCredentials(final User user) {
        return userService.getByCredentials(user);
    }
}
