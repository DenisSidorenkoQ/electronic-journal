package com.example.gateway.controller.user;

import com.example.gateway.client.UserClient;
import com.example.gateway.dto.user.SaveUserRequest;
import com.example.gateway.dto.user.UserResponse;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserClient userClient;

    @PostMapping
    ResponseEntity<UserResponse> save(@RequestBody SaveUserRequest request) {
        return userClient.save(request);
    }

    @GetMapping(value = "{userId}")
    ResponseEntity<UserResponse> getById(@PathVariable("userId") final Long userId) {
        ResponseEntity<UserResponse> response = userClient.getById(userId);
        return response;
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity handleException(FeignException exception) {
        return new ResponseEntity(HttpStatus.valueOf(exception.status()));
    }
}
