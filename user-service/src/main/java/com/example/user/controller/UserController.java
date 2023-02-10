package com.example.user.controller;

import com.example.user.converter.UserConverter;
import com.example.user.dto.user.GetUserByCredentialsRequest;
import com.example.user.dto.user.SaveUserRequest;
import com.example.user.dto.user.UserResponse;
import com.example.user.facade.UserFacade;
import com.example.user.model.User;
import com.example.user.model.UserAndRole;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {
    private final UserFacade userFacade;
    private final UserConverter converter;

    @PostMapping("/user")
    ResponseEntity save(@RequestBody SaveUserRequest request) {
        User userFromRequest = converter.fromDto(request);
        Optional<User> savedUser = userFacade.save(userFromRequest);

        return savedUser
                .map(user -> new ResponseEntity(converter.toDto(user), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }

    @GetMapping("/user/{userId}")
    ResponseEntity getById(@PathVariable("userId") final Long userId) {
        Optional<UserAndRole> foundUser = userFacade.getById(userId);

        return foundUser
                .map(user -> new ResponseEntity(converter.toDto(user), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }

    @PostMapping("/user/credentials")
    Optional<UserResponse> getByCredentials(@RequestBody GetUserByCredentialsRequest request) {
        User user = converter.fromDto(request);

        Optional<UserAndRole> foundUser = userFacade.getByCredentials(user);
        if (foundUser.isPresent()) {
            UserResponse response = converter.toDto(foundUser.get());
            return Optional.of(response);
        }

        return Optional.empty();
    }
}
