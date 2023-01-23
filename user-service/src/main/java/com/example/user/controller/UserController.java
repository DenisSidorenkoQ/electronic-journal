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
    ResponseEntity save(@RequestBody SaveUserRequest request) {
        User userFromRequest = converter.fromDto(request);
        Optional<User> savedUser = userFacade.save(userFromRequest);

        return savedUser
                .map(user -> new ResponseEntity(user, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }

    @GetMapping("{userId}")
    ResponseEntity getById(@PathVariable("userId") final Long userId) {
        Optional<User> findUser = userFacade.getById(userId);

        return findUser
                .map(value -> new ResponseEntity(converter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }

    @GetMapping
    ResponseEntity  getByLogin(@RequestBody GetUserByLoginRequest request) {
        Optional<User> findUser = userFacade.getByLogin(request.getLogin());

        return findUser
                .map(value -> new ResponseEntity(converter.toDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.CONFLICT));
    }
}
