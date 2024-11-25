package com.pbcompass.park_api.web.controller;

import com.pbcompass.park_api.entities.ClientParkingSpot;
import com.pbcompass.park_api.jwt.JwtUserDetails;
import com.pbcompass.park_api.repositories.projection.ClientParkingSpotProjection;
import com.pbcompass.park_api.services.ClientParkingSpotService;
import com.pbcompass.park_api.services.ParkingLotService;
import com.pbcompass.park_api.web.dto.PageableDto;
import com.pbcompass.park_api.web.dto.ParkingLotCreateDto;
import com.pbcompass.park_api.web.dto.ParkingLotResponseDto;
import com.pbcompass.park_api.web.dto.mapper.ClientParkingSpotMapper;
import com.pbcompass.park_api.web.dto.mapper.PageableMapper;
import com.pbcompass.park_api.web.exception.ErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.headers.Header;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

import static io.swagger.v3.oas.annotations.enums.ParameterIn.PATH;
import static io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY;

@Tag(name = "Parking Lot", description = "Operations for registering vehicle entry and exit from the parking lot.")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/parkingLots")
public class ParkingLotController {

    @Autowired
    private final ParkingLotService parkingLotService;

    @Autowired
    private final ClientParkingSpotService clientParkingSpotService;

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

    @GetMapping("/checkIn/{receipt}")
    @PreAuthorize("hasAnyRole('ADMIN', 'CLIENT')")
    public ResponseEntity<ParkingLotResponseDto> findByReceipt(@PathVariable String receipt) {
        ClientParkingSpot clientParkingSpot = clientParkingSpotService.findByReceipt(receipt);
        ParkingLotResponseDto dto = ClientParkingSpotMapper.toDto(clientParkingSpot);
        return ResponseEntity.ok(dto);
    }

    @Operation(
            summary = "Locale a vehicle parked",
            description = "Resouce to locale a vehicle parked " + "by receipt number. Request requires a bearer token.",
            security = @SecurityRequirement(name = "security"),
            parameters = {
                    @Parameter(in = PATH, name = "receipt", description = "Number generate by check-in")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Resource located successfully",
                            content = @Content(mediaType = " application/json;charset=UTF-8",
                                    schema = @Schema(implementation = ParkingLotResponseDto.class))),
                    @ApiResponse(responseCode = "404", description = "Receipt number not found.",
                            content = @Content(mediaType = " application/json;charset=UTF-8",
                                    schema = @Schema(implementation = ErrorMessage.class)))
            })
    @PutMapping("/checkOut/{receipt}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ParkingLotResponseDto> checkOut(@PathVariable String receipt) {
        ClientParkingSpot clientParkingSpot = parkingLotService.checkOut(receipt);
        ParkingLotResponseDto dto = ClientParkingSpotMapper.toDto(clientParkingSpot);
        return ResponseEntity.ok(dto);
    }

    @Operation(
            summary = "Find client parking records by CPF",
            description = "Find the parking records of the client by CPF. Requires the use of a bearer token.",
            security = @SecurityRequirement(name = "security"),
            parameters = {
                    @Parameter(in = PATH, name = "cpf", description = "CPF number of the client to be queried",
                            required = true
                    ),
                    @Parameter(in = QUERY, name = "page", description = "Represents the returned page",
                            content = @Content(schema = @Schema(type = "integer", defaultValue = "0"))
                    ),
                    @Parameter(in = QUERY, name = "size", description = "Represents the total number of elements per page",
                            content = @Content(schema = @Schema(type = "integer", defaultValue = "5"))
                    ),
                    @Parameter(in = QUERY, name = "sort", description = "Default sorting field 'entryDate,asc'. ",
                            array = @ArraySchema(schema = @Schema(type = "string", defaultValue = "entryDate,asc")),
                            hidden = true
                    )
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Resource successfully located",
                            content = @Content(mediaType = " application/json;charset=UTF-8",
                                    schema = @Schema(implementation = PageableDto.class))),
                    @ApiResponse(responseCode = "403", description = "Resource not allowed for CLIENT profile",
                            content = @Content(mediaType = " application/json;charset=UTF-8",
                                    schema = @Schema(implementation = ErrorMessage.class)))
            })
    @GetMapping("/cpf/{cpf}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PageableDto> findAllParkingLotByCpf(@PathVariable String cpf,
                                                              @PageableDefault(size = 5, sort = "entryDate",
                                                              direction = Sort.Direction.ASC) Pageable pageable){
        Page<ClientParkingSpotProjection> projection = clientParkingSpotService.findAllByClientCpf(cpf, pageable);
        PageableDto dto = PageableMapper.toDto(projection);
        return ResponseEntity.ok(dto);
    }

    @Operation(summary = "Find parking records of the logged-in customer",
            description = "Find the parking records of the logged-in customer. " +
                    "Requires the use of a bearer token.",
            security = @SecurityRequirement(name = "security"),
            parameters = {
                    @Parameter(in = QUERY, name = "page",
                            content = @Content(schema = @Schema(type = "integer", defaultValue = "0")),
                            description = "Represents the returned page"
                    ),
                    @Parameter(in = QUERY, name = "size",
                            content = @Content(schema = @Schema(type = "integer", defaultValue = "5")),
                            description = "Represents the total number of elements per page"
                    ),
                    @Parameter(in = QUERY, name = "sort", hidden = true,
                            array = @ArraySchema(schema = @Schema(type = "string", defaultValue = "entryDate,asc")),
                            description = "Default sorting field 'entryDate,asc'.")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Resource successfully located",
                            content = @Content(mediaType = "application/json;charset=UTF-8",
                                    schema = @Schema(implementation = ParkingLotResponseDto.class))),
                    @ApiResponse(responseCode = "403", description = "Resource not allowed for ADMIN profile",
                            content = @Content(mediaType = "application/json;charset=UTF-8",
                                    schema = @Schema(implementation = ErrorMessage.class)))
            })

    @GetMapping()
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<PageableDto> findAllParkingLotByCpf(@AuthenticationPrincipal JwtUserDetails userDetails,
                                                              @PageableDefault(size = 5, sort = "entryDate",
                                                                      direction = Sort.Direction.ASC) Pageable pageable){
        Page<ClientParkingSpotProjection> projection = clientParkingSpotService.findAllByUserId(userDetails.getId(), pageable);
        PageableDto dto = PageableMapper.toDto(projection);
        return ResponseEntity.ok(dto);
    }
}
