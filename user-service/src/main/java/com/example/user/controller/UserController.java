package com.example.user.controller;

import com.example.user.converter.UserConverter;
import com.example.user.dto.user.GetUserByLoginRequest;
import com.example.user.dto.user.SaveUserRequest;
import com.example.user.dto.user.UserResponse;
import com.example.user.facade.UserFacade;
import com.example.user.model.User;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
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
    ResponseEntity save(@RequestBody SaveUserRequest request, HttpServletResponse response) {
        User userFromRequest = converter.fromDto(request);
        Optional<User> savedUser = userFacade.save(userFromRequest);

        return savedUser
                .map(user -> new ResponseEntity(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }

    @GetMapping("{userId}")
    UserResponse getUserById(@PathVariable("userId") final Long userId) {
        return converter.toDto(userFacade.getUserById(userId));
    }

    @GetMapping
    UserResponse getUserByLogin(@RequestBody GetUserByLoginRequest request) {
        User findUser = userFacade.getUserByLogin(request.getLogin()).orElseGet(() -> User.builder().build());
        return converter.toDto(findUser);
    }
}
