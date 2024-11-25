package com.pbcompass.park_api.web.controller;

import com.pbcompass.park_api.entities.ClientParkingSpot;
import com.pbcompass.park_api.services.ParkingLotService;
import com.pbcompass.park_api.web.dto.ParkingLotCreateDto;
import com.pbcompass.park_api.web.dto.ParkingLotResponseDto;
import com.pbcompass.park_api.web.dto.mapper.ClientParkingSpotMapper;
import com.pbcompass.park_api.web.exception.ErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/parkingLots")
public class ParkingLotController {

    @Autowired
    private final ParkingLotService parkingLotService;

    @Operation(
            summary = "Operation check in",
            description = "Resource to add a vehicle to the parking lot. Request requires a bearer token. Access restricted to Role='ADMIN'.",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Resource successfully added",
                            headers = @Header(name = HttpHeaders.LOCATION, description = "URL of the created resource"),
                            content = @Content(mediaType = "application/json;charset=UTF-8",
                            schema = @Schema(implementation = ParkingLotResponseDto.class))
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Access denied for CLIENT role",
                            content = @Content(mediaType = "application/json;charset=UTF-8",
                                    schema = @Schema(implementation = ErrorMessage.class))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Possible causes: <br/> " +
                            "- Client cpf not registered in the system; <br/>" +
                            "- Non free spot was found",
                            content = @Content(mediaType = "application/json;charset=UTF-8",
                                    schema = @Schema(implementation = ErrorMessage.class))
                    ),
                    @ApiResponse(
                            responseCode = "422",
                            description = "Resource not process by missing data or invalid data",
                            content = @Content(mediaType = "application/json;charset=UTF-8",
                                    schema = @Schema(implementation = ErrorMessage.class))
                    )
            }
    )
    @PostMapping("/checkIn")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ParkingLotResponseDto> checkIn(@RequestBody @Valid ParkingLotCreateDto dto) {
        ClientParkingSpot clientParkingSpot = ClientParkingSpotMapper.toClientParkingSpot(dto);
        parkingLotService.checkIn(clientParkingSpot);
        ParkingLotResponseDto responseDto = ClientParkingSpotMapper.toDto(clientParkingSpot);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri().path("/{receipt}")
                .buildAndExpand(clientParkingSpot.getReceipt())
                .toUri();
        return ResponseEntity.created(location).body(responseDto);
    }
}
