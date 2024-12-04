package com.pbcompass.park_api;

import com.pbcompass.park_api.entities.Client;
import com.pbcompass.park_api.entities.User;
import com.pbcompass.park_api.repositories.ClientRepository;
import com.pbcompass.park_api.repositories.UserRepository;
import com.pbcompass.park_api.services.ClientService;
import com.pbcompass.park_api.services.UserService;
import com.pbcompass.park_api.web.dto.*;
import com.pbcompass.park_api.web.dto.mapper.ClientMapper;
import com.pbcompass.park_api.web.dto.mapper.UserMapper;
import com.pbcompass.park_api.web.exception.ErrorMessage;
import org.assertj.core.api.Assertions;
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
    public void createClient_WithValidCredentials_ReturnStatus201(){
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

        Assertions.assertThat(responseBody).isNotNull();
        Assertions.assertThat(responseBody.getId()).isNotNull();
        Assertions.assertThat(responseBody.getName()).isEqualTo("joaop");
        Assertions.assertThat(responseBody.getCpf()).isEqualTo("10909208905");
    }

    @Test
    public void createClient_WithAlreadyRegisteredCpf_ReturnErroMessageStatus409(){
        UserCreateDto user = new UserCreateDto("client@gmail.com", "123456");
        User newUser = userRepository.save(UserMapper.toUser(user));
        userService.save(newUser);

        ClientCreateDto client = new ClientCreateDto("joaop", "10909208905");
        Client newClient = clientRepository.save(ClientMapper.toClient(client));
        newClient.setUser(userService.findById(newUser.getId()));
        clientService.insert(newClient);


        ErrorMessage responseBody = testClient
                .post()
                .uri("/api/v1/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .headers(JwtAuthentication.getHeaderAuthentication(testClient, newUser.getUsername(), "123456"))
                .bodyValue(new ClientCreateDto("joaop", "10909208905"))
                .exchange()
                .expectStatus().isEqualTo(409)
                .expectBody(ErrorMessage.class)
                .returnResult().getResponseBody();

        Assertions.assertThat(responseBody).isNotNull();
        Assertions.assertThat(responseBody.getStatus()).isEqualTo(409);
    }

    @Test
    public void createClient_WithInvalidData_ReturnErroMessageStatus422(){
        UserCreateDto user = new UserCreateDto("client@gmail.com", "123456");
        User newUser = userRepository.save(UserMapper.toUser(user));

        userService.save(newUser);

        ErrorMessage responseBody = testClient
                .post()
                .uri("/api/v1/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .headers(JwtAuthentication.getHeaderAuthentication(testClient, newUser.getUsername(), "123456"))
                .bodyValue(new ClientCreateDto("", ""))
                .exchange()
                .expectStatus().isEqualTo(422)
                .expectBody(ErrorMessage.class)
                .returnResult().getResponseBody();

        Assertions.assertThat(responseBody).isNotNull();
        Assertions.assertThat(responseBody.getStatus()).isEqualTo(422);

        testClient
                .post()
                .uri("/api/v1/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .headers(JwtAuthentication.getHeaderAuthentication(testClient, newUser.getUsername(), "123456"))
                .bodyValue(new ClientCreateDto("joao", "00000000000"))
                .exchange()
                .expectStatus().isEqualTo(422)
                .expectBody(ErrorMessage.class)
                .returnResult().getResponseBody();

        Assertions.assertThat(responseBody).isNotNull();
        Assertions.assertThat(responseBody.getStatus()).isEqualTo(422);

        testClient
                .post()
                .uri("/api/v1/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .headers(JwtAuthentication.getHeaderAuthentication(testClient, newUser.getUsername(), "123456"))
                .bodyValue(new ClientCreateDto("joao", "109.092.089-05"))
                .exchange()
                .expectStatus().isEqualTo(422)
                .expectBody(ErrorMessage.class)
                .returnResult().getResponseBody();

        Assertions.assertThat(responseBody).isNotNull();
        Assertions.assertThat(responseBody.getStatus()).isEqualTo(422);

    }

    @Test
    public void createClient_WithUserNotAllowed_ReturnErroMessageStatus401(){
        UserCreateDto user = new UserCreateDto("admin@gmail.com", "123456");
        User newUser = userRepository.save(UserMapper.toUser(user));
        newUser.setRole(User.Role.ROLE_ADMIN);
        userService.save(newUser);

        ErrorMessage responseBody = testClient
                .post()
                .uri("/api/v1/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .headers(JwtAuthentication.getHeaderAuthentication(testClient, newUser.getUsername(), "123456"))
                .bodyValue(new ClientCreateDto("joaop", "10909208905"))
                .exchange()
                .expectStatus().isEqualTo(401)
                .expectBody(ErrorMessage.class)
                .returnResult().getResponseBody();

        Assertions.assertThat(responseBody).isNotNull();
        Assertions.assertThat(responseBody.getStatus()).isEqualTo(401);
    }

    @Test
    public void findClient_WithExistentIdByAdmin_ReturnStatus200(){
        UserCreateDto user = new UserCreateDto("admin@gmail.com", "123456");
        User newUser = userRepository.save(UserMapper.toUser(user));
        newUser.setRole(User.Role.ROLE_ADMIN);
        userService.save(newUser);

        ClientResponseDto responseBody = testClient
                .post()
                .uri("/api/v1/clients/1")
                .contentType(MediaType.APPLICATION_JSON)
                .headers(JwtAuthentication.getHeaderAuthentication(testClient, newUser.getUsername(), "123456"))
                .exchange()
                .expectStatus().isOk()
                .expectBody(ClientResponseDto.class)
                .returnResult().getResponseBody();

        Assertions.assertThat(responseBody).isNotNull();
        Assertions.assertThat(responseBody.getId()).isEqualTo(1);


    }

    @Test
    public void findClient_WithNonExistentIdByAdmin_ReturnErrorMessageStatus404(){
        UserCreateDto user = new UserCreateDto("admin@gmail.com", "123456");
        User newUser = userRepository.save(UserMapper.toUser(user));
        newUser.setRole(User.Role.ROLE_ADMIN);
        userService.save(newUser);

        ErrorMessage responseBody = testClient
                .post()
                .uri("/api/v1/clients/0")
                .contentType(MediaType.APPLICATION_JSON)
                .headers(JwtAuthentication.getHeaderAuthentication(testClient, newUser.getUsername(), "123456"))
                .exchange()
                .expectStatus().isNotFound()
                .expectBody(ErrorMessage.class)
                .returnResult().getResponseBody();

        Assertions.assertThat(responseBody).isNotNull();
        Assertions.assertThat(responseBody.getStatus()).isEqualTo(404);
    }

    @Test
    public void findClient_WithExistentIdByClient_ReturnErrorMessageStatus403(){
        UserCreateDto user = new UserCreateDto("client@gmail.com", "123456");
        User newUser = userRepository.save(UserMapper.toUser(user));
        userService.save(newUser);

        ClientCreateDto client = new ClientCreateDto("joaop", "10909208905");
        Client newClient = new Client();
        newClient.setUser(userService.findById(newUser.getId()));
        newClient = clientRepository.save(ClientMapper.toClient(client));
        clientService.insert(newClient);

        ErrorMessage responseBody = testClient
                .post()
                .uri("/api/v1/clients/0")
                .contentType(MediaType.APPLICATION_JSON)
                .headers(JwtAuthentication.getHeaderAuthentication(testClient, newClient.getName(), "123456"))
                .exchange()
                .expectStatus().isNotFound()
                .expectBody(ErrorMessage.class)
                .returnResult().getResponseBody();

        Assertions.assertThat(responseBody).isNotNull();
        Assertions.assertThat(responseBody.getStatus()).isEqualTo(404);
    }

    @Test
    public void findClients_WithPageableByAdmin_ReturnClientsWithStatus200(){
        UserCreateDto user = new UserCreateDto("admin@gmail.com", "123456");
        User newUser = userRepository.save(UserMapper.toUser(user));
        newUser.setRole(User.Role.ROLE_ADMIN);
        userService.save(newUser);

        PageableDto responseBody = testClient
                .post()
                .uri("/api/v1/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .headers(JwtAuthentication.getHeaderAuthentication(testClient, newUser.getUsername(), "123456"))
                .exchange()
                .expectStatus().isOk()
                .expectBody(PageableDto.class)
                .returnResult().getResponseBody();

        Assertions.assertThat(responseBody).isNotNull();
        Assertions.assertThat(responseBody.getContent().size()).isEqualTo(2);
        Assertions.assertThat(responseBody.getNumber()).isEqualTo(0);
        Assertions.assertThat(responseBody.getTotalPages()).isEqualTo(1);

        responseBody = testClient
                .post()
                .uri("/api/v1/clients?size=17&page=1")
                .contentType(MediaType.APPLICATION_JSON)
                .headers(JwtAuthentication.getHeaderAuthentication(testClient, newUser.getUsername(), "123456"))
                .exchange()
                .expectStatus().isOk()
                .expectBody(PageableDto.class)
                .returnResult().getResponseBody();

        Assertions.assertThat(responseBody).isNotNull();
        Assertions.assertThat(responseBody.getContent().size()).isEqualTo(2);
        Assertions.assertThat(responseBody.getNumber()).isEqualTo(1);
        Assertions.assertThat(responseBody.getTotalPages()).isEqualTo(2);
    }

    @Test
    public void findClients_WithPageableByClient_ReturnClientsWithStatus403(){
        UserCreateDto user = new UserCreateDto("admin@gmail.com", "123456");
        User newUser = userRepository.save(UserMapper.toUser(user));
        userService.save(newUser);

        ErrorMessage responseBody = testClient
                .post()
                .uri("/api/v1/clients")
                .contentType(MediaType.APPLICATION_JSON)
                .headers(JwtAuthentication.getHeaderAuthentication(testClient, newUser.getUsername(), "123456"))
                .exchange()
                .expectStatus().isForbidden()
                .expectBody(ErrorMessage.class)
                .returnResult().getResponseBody();

        Assertions.assertThat(responseBody).isNotNull();
        Assertions.assertThat(responseBody.getStatus()).isEqualTo(403);;
    }

    @Test
    public void findClient_WithDataOfClientToken_ReturnClientsWithStatus200(){
        UserCreateDto user = new UserCreateDto("admin@gmail.com", "123456");
        User newUser = userRepository.save(UserMapper.toUser(user));
        userService.save(newUser);

        ClientCreateDto client = new ClientCreateDto("joaop", "10909208905");
        Client newClient = new Client();
        newClient.setUser(userService.findById(newUser.getId()));
        newClient = clientRepository.save(ClientMapper.toClient(client));

        ClientResponseDto responseBody = testClient
                .post()
                .uri("/api/v1/clients/details")
                .contentType(MediaType.APPLICATION_JSON)
                .headers(JwtAuthentication.getHeaderAuthentication(testClient, newClient.getName(), "123456"))
                .exchange()
                .expectStatus().isOk()
                .expectBody(ClientResponseDto.class)
                .returnResult().getResponseBody();

        Assertions.assertThat(responseBody).isNotNull();
        Assertions.assertThat(responseBody.getCpf()).isEqualTo("10909208905");
        Assertions.assertThat(responseBody.getName()).isEqualTo("joaop");
        Assertions.assertThat(responseBody.getId()).isEqualTo(1);
    }

    @Test
    public void findClient_WithDataOfClientToken_ReturnClientsWithStatus403(){
        UserCreateDto user = new UserCreateDto("admin@gmail.com", "123456");
        User newUser = userRepository.save(UserMapper.toUser(user));
        newUser.setRole(User.Role.ROLE_ADMIN);
        userService.save(newUser);

        ClientCreateDto client = new ClientCreateDto("joaop", "10909208905");
        Client newClient = new Client();
        newClient.setUser(userService.findById(newUser.getId()));
        newClient = clientRepository.save(ClientMapper.toClient(client));

        ErrorMessage responseBody = testClient
                .post()
                .uri("/api/v1/clients/details")
                .contentType(MediaType.APPLICATION_JSON)
                .headers(JwtAuthentication.getHeaderAuthentication(testClient, newClient.getName(), "123456"))
                .exchange()
                .expectStatus().isForbidden()
                .expectBody(ErrorMessage.class)
                .returnResult().getResponseBody();

        Assertions.assertThat(responseBody).isNotNull();
        Assertions.assertThat(responseBody.getStatus()).isEqualTo(403);
    }
}


