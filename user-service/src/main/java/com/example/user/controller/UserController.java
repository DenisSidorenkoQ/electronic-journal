package com.example.user.controller;

import com.example.user.converter.UserConverter;
import com.example.user.dto.GetUserByLoginRequest;
import com.example.user.dto.SaveUserRequest;
import com.example.user.dto.UserResponse;
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
        Optional<User> savedUser = userFacade.save(request);

        return savedUser
                .map(user -> new ResponseEntity(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.FORBIDDEN));
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
