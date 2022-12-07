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
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthorizationRestController {
    private final UserService userService;
    private final Jwt jwt;

    @PostMapping
    protected AuthResultDto userAuthorization(@RequestBody final CredentialsDto credentials) throws CredentialNotFoundException {
        String token;
        if (userService.isExists(credentials.getLogin(), credentials.getPassword())) {
            token = jwt.generateToken(credentials.getLogin());
            return new AuthResultDto(token);
        } else {
            throw new CredentialNotFoundException("User not exist");
        }
    }
}
