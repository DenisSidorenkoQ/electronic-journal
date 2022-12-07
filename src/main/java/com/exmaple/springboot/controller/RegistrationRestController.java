package com.exmaple.springboot.controller;

import com.exmaple.springboot.config.jwt.Jwt;
import com.exmaple.springboot.dto.AuthResultDto;
import com.exmaple.springboot.dto.CredentialsDto;
import com.exmaple.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.security.auth.login.CredentialNotFoundException;

@Slf4j
@RestController
@RequestMapping("/api/register")
@RequiredArgsConstructor
public class RegistrationRestController {
    private final UserService userService;

    @PostMapping
    protected void userRegistration(@RequestBody final CredentialsDto credentials) throws CredentialNotFoundException {
        if (!userService.isExists(credentials.getLogin())) {
            userService.register(credentials.getLogin(), credentials.getPassword(), credentials.getRole());
        } else {
            throw new CredentialNotFoundException("User not exist");
        }
    }
}
