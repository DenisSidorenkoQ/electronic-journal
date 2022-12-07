package com.exmaple.springboot.service;

import com.exmaple.springboot.model.User;
import com.exmaple.springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    public boolean isExists(String login) {
        return userRepository.getUserByLogin(login) != null;
    }
    public boolean isExists(String username, String password) {
        Optional<String> encryptedPassword = userRepository.getUserHashedPassword(username);
        return encryptedPassword.filter(hash ->  passwordEncoder.matches(password, hash)).isPresent();
    }

    public boolean register(String username, String password, String role) {

        if (isExists(username)) {
            return false;
        }
        String encryptedPassword = passwordEncoder.encode(password);

        userRepository.insertNewUser(username, encryptedPassword, role);
        return true;
    }
}
