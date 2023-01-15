package com.example.gateway.client;

import com.example.gateway.dto.SaveOrGetUserRequest;
import com.example.gateway.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "user", url = "${services.user.url}/api/v1/users")
public interface UserClient {

    @PostMapping
    UserResponse saveOrGet(final SaveOrGetUserRequest saveOrGetUserRequest);

    @GetMapping("{userId}")
    UserResponse get(@PathVariable("userId") final Long userId);
}
