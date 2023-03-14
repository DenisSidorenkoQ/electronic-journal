package com.example.gateway.controller;

import com.example.gateway.client.UserClient;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TeacherController {
    private final UserClient userClient;

    @GetMapping("/user/{userId}/teachers")
    ResponseEntity getByUserId(@PathVariable final Long userId) {
        return userClient.getTeacherByUserId(userId);
    }
}
