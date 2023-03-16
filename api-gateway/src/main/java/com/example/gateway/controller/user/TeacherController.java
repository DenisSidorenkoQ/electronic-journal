package com.example.gateway.controller.user;

import com.example.gateway.client.UserClient;
import com.example.gateway.dto.teacher.SaveTeacherRequest;
import com.example.gateway.dto.teacher.TeacherResponse;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class TeacherController {
    private final UserClient userClient;

    @PostMapping("/teachers")
    TeacherResponse saveOrGet(@RequestBody SaveTeacherRequest request) {
        return userClient.saveOrGetTeacher(request);
    }

    @GetMapping("/user/{userId}/teachers")
    ResponseEntity getByUserId(@PathVariable final Long userId) {
        return userClient.getTeacherByUserId(userId);
    }
}
