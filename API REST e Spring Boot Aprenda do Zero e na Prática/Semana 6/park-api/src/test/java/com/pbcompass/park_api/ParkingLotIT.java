package com.pbcompass.park_api;

import com.pbcompass.park_api.web.dto.ParkingLotCreateDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = "classpath:sql/parkingLot/parkingLot-insert.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "classpath:sql/parkingLot/parkingLot-delete.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class ParkingLotIT {

    @Autowired
    WebTestClient testClient;

    @Test
    public void createCheckIn_WithValidData_ReturnCreatedAndLocation() {
        ParkingLotCreateDto createDto = ParkingLotCreateDto.builder()
                .licensePlate("WER-1111").brand("FIAT").model("PALIO")
                .color("BLUE").clientCpf("09191773016").build();

        testClient.post().uri("/api/v1/parkingLot/checkIn")
                .contentType(MediaType.APPLICATION_JSON)
                .headers(JwtAuthentication.getHeaderAuthentication(testClient, "ana@email.com.br", "123456"))
                .bodyValue(createDto)
                .exchange()
                .expectStatus().isCreated()
                .expectHeader().exists(HttpHeaders.LOCATION)
                .expectBody()
                .jsonPath("licensePlate").isEqualTo("WER-1111")
                .jsonPath("brand").isEqualTo("FIAT")
                .jsonPath("model").isEqualTo("PALIO")
                .jsonPath("color").isEqualTo("BLUE")
                .jsonPath("clientCpf").isEqualTo("09191773016")
                .jsonPath("receipt_number").exists()
                .jsonPath("entry_date").exists()
                .jsonPath("id_parking_spot").exists();
    }

    @Test
    public void createCheckIn_WithClientRole_ReturnErrorStatus403() {
        ParkingLotCreateDto createDto = ParkingLotCreateDto.builder()
                .licensePlate("WER-1111").brand("FIAT").model("PALIO")
                .color("BLUE").clientCpf("09191773016").build();

        testClient.post().uri("/api/v1/parkingLot/checkIn")
                .contentType(MediaType.APPLICATION_JSON)
                .headers(JwtAuthentication.getHeaderAuthentication(testClient, "bia@email.com.br", "123456"))
                .bodyValue(createDto)
                .exchange()
                .expectStatus().isForbidden()
                .expectBody()
                .jsonPath("status").isEqualTo("403")
                .jsonPath("path").isEqualTo("/api/v1/parkingLot/checkIn")
                .jsonPath("method").isEqualTo("POST");
    }

    @Test
    public void createCheckIn_WithInvalidData_ReturnErrorStatus422() {
        ParkingLotCreateDto createDto = ParkingLotCreateDto.builder()
                .licensePlate("").brand("").model("")
                .color("").clientCpf("").build();

        testClient.post().uri("/api/v1/parkingLot/checkIn")
                .contentType(MediaType.APPLICATION_JSON)
                .headers(JwtAuthentication.getHeaderAuthentication(testClient, "bia@email.com.br", "123456"))
                .bodyValue(createDto)
                .exchange()
                .expectStatus().isEqualTo(422)
                .expectBody()
                .jsonPath("status").isEqualTo("422")
                .jsonPath("path").isEqualTo("/api/v1/parkingLot/checkIn")
                .jsonPath("method").isEqualTo("POST");
    }

    @Test
    public void createCheckIn_WithNonExistentCpf_ReturnErrorStatus422() {
        ParkingLotCreateDto createDto = ParkingLotCreateDto.builder()
                .licensePlate("WER-1111").brand("FIAT").model("PALIO")
                .color("BLUE").clientCpf("10909208905").build();

        testClient.post().uri("/api/v1/parkingLot/checkIn")
                .contentType(MediaType.APPLICATION_JSON)
                .headers(JwtAuthentication.getHeaderAuthentication(testClient, "ana@email.com.br", "123456"))
                .bodyValue(createDto)
                .exchange()
                .expectStatus().isNotFound()
                .expectBody()
                .jsonPath("status").isEqualTo("404")
                .jsonPath("path").isEqualTo("/api/v1/parkingLot/checkIn")
                .jsonPath("method").isEqualTo("POST");
    }


    // Annotation with new sql cript
    @Test
    public void createCheckIn_WithOccupiedSpot_ReturnErrorStatus422() {
        ParkingLotCreateDto createDto = ParkingLotCreateDto.builder()
                .licensePlate("WER-1111").brand("FIAT").model("PALIO")
                .color("BLUE").clientCpf("09191773016").build();

        testClient.post().uri("/api/v1/parkingLot/checkIn")
                .contentType(MediaType.APPLICATION_JSON)
                .headers(JwtAuthentication.getHeaderAuthentication(testClient, "ana@email.com.br", "123456"))
                .bodyValue(createDto)
                .exchange()
                .expectStatus().isNotFound()
                .expectBody()
                .jsonPath("status").isEqualTo("404")
                .jsonPath("path").isEqualTo("/api/v1/parkingLot/checkIn")
                .jsonPath("method").isEqualTo("POST");
    }
}
