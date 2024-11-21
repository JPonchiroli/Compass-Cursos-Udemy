package com.pbcompass.park_api;

import com.pbcompass.park_api.entities.User;
import com.pbcompass.park_api.jwt.JwtToken;
import com.pbcompass.park_api.repositories.UserRepository;
import com.pbcompass.park_api.services.UserService;
import com.pbcompass.park_api.web.dto.UserCreateDto;
import com.pbcompass.park_api.web.dto.UserLoginDto;
import com.pbcompass.park_api.web.dto.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AuthenticationIT {
    @Autowired
    WebTestClient testClient;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void authenticate_WithValidCredentials_ReturnTokenWithStatus200(){
        UserCreateDto user = new UserCreateDto("admin@gmail.com", "123456");
        User newUser = userRepository.save(UserMapper.toUser(user));

        userService.save(newUser);

        JwtToken responseBody = testClient
                .post()
                .uri("/api/v1/auth")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(new UserLoginDto("admin@gmail.com", "123456"))
                .exchange()
                .expectStatus().isOk()
                .expectBody(JwtToken.class)
                .returnResult().getResponseBody();

        org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
    }

}
