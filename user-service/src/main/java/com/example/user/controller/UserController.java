package com.example.user.controller;

import com.example.user.converter.UserConverter;
import com.example.user.dto.user.GetUserByCredentialsRequest;
import com.example.user.dto.user.SaveUserRequest;
import com.example.user.dto.user.UserResponse;
import com.example.user.facade.UserFacade;
import com.example.user.model.User;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.mapstruct.control.MappingControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserFacade userFacade;
    private final UserConverter converter;

    @PostMapping
    ResponseEntity save(@RequestBody SaveUserRequest request) {
        User userFromRequest = converter.fromDto(request);
        Optional<User> savedUser = userFacade.save(userFromRequest);

        return savedUser
                .map(user -> new ResponseEntity(converter.toDto(user), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }

    @GetMapping("{userId}")
    UserResponse getById(@PathVariable("userId") final Long userId) {
        Optional<User> foundUser = userFacade.getById(userId);

        return converter.toDto(foundUser.get());
    }

    @GetMapping
    Optional<UserResponse> getByCredentials(@RequestParam("login") String login, @RequestParam("password") String password) {
        User user = User.builder().login(login).password(password).build();

        Optional<User> foundUser = userFacade.getByCredentials(user);
        UserResponse response = converter.toDto(foundUser.get());
        return Optional.of(response);
    }
}
