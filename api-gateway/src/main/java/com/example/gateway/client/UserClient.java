package com.example.gateway.client;

import com.example.gateway.dto.user.SaveUserRequest;
import com.example.gateway.dto.user.UserResponse;
import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user", url = "${services.user.url}/api/v1/user")
public interface UserClient {
    @GetMapping
    Optional<UserResponse> getByCredentials(@RequestParam(value = "login") final String login, @RequestParam(value = "password") final String password);

    @GetMapping("{userId}")
    ResponseEntity<UserResponse> getById(@PathVariable("userId") final Long userId);

    @PostMapping
    ResponseEntity<UserResponse> save(@RequestBody SaveUserRequest request);
}
