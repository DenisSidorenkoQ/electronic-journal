package com.example.gateway.controller;

import com.example.gateway.client.UserClient;
import com.example.gateway.config.security.jwt.JwtProvider;
import com.example.gateway.dto.auth.AuthorizationUserRequest;
import com.example.gateway.dto.user.GetUserByCredentialsRequest;
import com.example.gateway.dto.user.UserResponse;
import java.io.IOException;
import java.time.Duration;
import java.util.Optional;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authorization")
public class AuthController {
    private static final String TOKEN_NAME = "JWT";
    private static final long EXPIRATION = Duration.ofHours(3).toSeconds();
    private final JwtProvider jwtProvider;
    private final UserClient userClient;
    private final String redirectUrl;

    public AuthController(JwtProvider jwtProvider,
                          UserClient userClient,
                          @Value("${security.success-redirect-url}") String redirectUrl
    ) {
        this.jwtProvider = jwtProvider;
        this.userClient = userClient;
        this.redirectUrl = redirectUrl;
    }

    @PostMapping("/login")
    public void login(
            @RequestBody AuthorizationUserRequest request,
            HttpServletResponse response
    ) throws IOException {
        GetUserByCredentialsRequest getUserByCredentialsRequest =
                GetUserByCredentialsRequest
                        .builder()
                        .login(request.getLogin())
                        .password(request.getPassword())
                        .build();

        Optional<UserResponse> userResponse =
                userClient.getByCredentials(getUserByCredentialsRequest);
        if (userResponse.isPresent()) {
            UserResponse user = userResponse.get();

            String token = jwtProvider.generateToken(
                    user.getId(),
                    user.getLogin(),
                    user.getRoleName()
            );
            final Cookie cookie = new Cookie(TOKEN_NAME, token);
            cookie.setPath("/");
            cookie.setHttpOnly(true);
            cookie.setMaxAge((int) EXPIRATION);
            response.addCookie(cookie);

            response.setStatus(HttpStatus.OK.value());
        } else {
            response.setStatus(HttpStatus.CONFLICT.value());
        }

    }
}
