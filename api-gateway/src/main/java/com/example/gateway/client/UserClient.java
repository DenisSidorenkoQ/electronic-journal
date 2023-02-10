package com.example.gateway.client;

import com.example.gateway.dto.student.SaveStudentRequest;
import com.example.gateway.dto.student.StudentResponse;
import com.example.gateway.dto.user.GetUserByCredentialsRequest;
import com.example.gateway.dto.user.SaveUserRequest;
import com.example.gateway.dto.user.SaveUserResponse;
import com.example.gateway.dto.user.UserResponse;
import feign.Headers;
import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user", url = "${services.user.url}/api/v1")
public interface UserClient {
//UserController
    @PostMapping("/user/credentials")
    Optional<UserResponse> getByCredentials(@RequestBody GetUserByCredentialsRequest request);

    @GetMapping("/user/{userId}")
    ResponseEntity<UserResponse> getById(@PathVariable("userId") final Long userId);

    @PostMapping("/user")
    ResponseEntity<SaveUserResponse> save(@RequestBody SaveUserRequest request);

//StudentController
    @PostMapping("/student")
    StudentResponse saveOrGetStudent(@RequestBody SaveStudentRequest request);

    @GetMapping("/user/{userId}/student")
    ResponseEntity<StudentResponse> getStudentByUserId(@PathVariable("userId") final Long userId);

    @GetMapping("/student/{studentId}")
    ResponseEntity<StudentResponse> getStudentById(@PathVariable("studentId") Long studentId);
}
