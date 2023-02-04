package com.example.gateway.client;

import com.example.gateway.dto.user.GetUserByCredentialsRequest;
import com.example.gateway.dto.user.SaveUserRequest;
import com.example.gateway.dto.user.SaveUserResponse;
import com.example.gateway.dto.user.UserResponse;
import feign.Headers;
import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user", url = "${services.user.url}/api/v1/user")
public interface UserClient {

    @PostMapping("credentials")
    Optional<UserResponse> getByCredentials(GetUserByCredentialsRequest request);

    @GetMapping("{userId}")
    ResponseEntity<UserResponse> getById(@PathVariable("userId") final Long userId);

    @PostMapping
    ResponseEntity<SaveUserResponse> save(@RequestBody SaveUserRequest request);


}
