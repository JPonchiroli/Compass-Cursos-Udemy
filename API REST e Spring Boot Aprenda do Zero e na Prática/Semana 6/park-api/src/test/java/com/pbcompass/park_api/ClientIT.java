package com.pbcompass.park_api;

import com.pbcompass.park_api.entities.User;
import com.pbcompass.park_api.repositories.ClientRepository;
import com.pbcompass.park_api.repositories.UserRepository;
import com.pbcompass.park_api.services.ClientService;
import com.pbcompass.park_api.services.UserService;
import com.pbcompass.park_api.web.dto.ClientCreateDto;
import com.pbcompass.park_api.web.dto.ClientResponseDto;
import com.pbcompass.park_api.web.dto.UserCreateDto;
import com.pbcompass.park_api.web.dto.UserResponseDto;
import com.pbcompass.park_api.web.dto.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientIT {

    @Autowired
    WebTestClient testClient;

    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ClientService clientService;

    @Autowired
    ClientRepository clientRepository;

    @Test
    public void createCliente_WithValidCredentials_ReturnStatus201(){
        UserCreateDto user = new UserCreateDto("client@gmail.com", "123456");
        User newUser = userRepository.save(UserMapper.toUser(user));

        userService.save(newUser);

        ClientResponseDto responseBody = testClient
                .post()
                .uri("/api/v1/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .headers(JwtAuthentication.getHeaderAuthentication(testClient, newUser.getUsername(), "123456"))
                .bodyValue(new ClientCreateDto("joaop", "10909208905"))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(ClientResponseDto.class)
                .returnResult().getResponseBody();

        org.assertj.core.api.Assertions.assertThat(responseBody).isNotNull();
        /*org.assertj.core.api.Assertions.assertThat(responseBody.getId()).isNotNull();
        org.assertj.core.api.Assertions.assertThat(responseBody.getName()).isEqualTo("joao");
        org.assertj.core.api.Assertions.assertThat(responseBody.getCpf()).isEqualTo("10909208905");*/
    }

}


