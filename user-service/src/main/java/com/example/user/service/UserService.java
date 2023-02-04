package com.example.user.service;

import com.example.user.model.User;
import com.example.user.model.UserAndRole;
import com.example.user.repository.UserRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<UserAndRole> getUserById(final Long userId) {
        return userRepository.getByUserId(userId);
    }

    public Optional<User> getUserByLogin(final String login) {
        return userRepository.getByLogin(login);
    }

    public User save(final User user) {
        return userRepository.save(user.getLogin(), user.getPassword(), user.getRoleId());
    }

    public Optional<UserAndRole> getByCredentials(final User user) {
        return userRepository.getByCredentials(user.getLogin(), user.getPassword());
    }
}
