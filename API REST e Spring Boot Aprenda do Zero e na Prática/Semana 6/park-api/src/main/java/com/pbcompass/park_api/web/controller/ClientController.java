package com.pbcompass.park_api.web.controller;

import com.pbcompass.park_api.entities.Client;
import com.pbcompass.park_api.jwt.JwtUserDetails;
import com.pbcompass.park_api.repositories.projection.ClientProjection;
import com.pbcompass.park_api.services.ClientService;
import com.pbcompass.park_api.services.UserService;
import com.pbcompass.park_api.web.dto.ClientCreateDto;
import com.pbcompass.park_api.web.dto.ClientResponseDto;
import com.pbcompass.park_api.web.dto.PageableDto;
import com.pbcompass.park_api.web.dto.UserResponseDto;
import com.pbcompass.park_api.web.dto.mapper.ClientMapper;
import com.pbcompass.park_api.web.dto.mapper.PageableMapper;
import com.pbcompass.park_api.web.exception.ErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY;

@Tag(name = "Clients", description = "Contains all operations related to a client resource")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/clients")
public class ClientController {

    private final ClientService clientService;
    private final UserService userService;

    @Operation(summary = "Insert a new Client", description = "Resource to create a new client liked with a user. " +
            "The request requires a Bearer Token. Access restricted to CLIENT",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "201", description = "Resource created successfully",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDto.class))),
                    @ApiResponse(responseCode = "403", description = "Resource not authorized to ADMIN profile",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "409", description = "Client CPF already registered in the system",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "422", description = "Resource not processed buy wrong data entry",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
            })
    @PostMapping
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<ClientResponseDto> insert(@RequestBody @Valid ClientCreateDto dto,
                                                    @AuthenticationPrincipal JwtUserDetails userDetails) {
        Client client = ClientMapper.toClient(dto);
        client.setUser(userService.findById(userDetails.getId()));
        clientService.insert(client);
        return ResponseEntity.status(201).body(ClientMapper.toDto(client));
    }

    @Operation(summary = "Locale a Client", description = "Resource to locale a client by id. " +
            "The request requires a Bearer Token. Access restricted to ADMIN",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Resource found successfully",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDto.class))),
                    @ApiResponse(responseCode = "404", description = "Client not found",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
                    @ApiResponse(responseCode = "403", description = "Resource not allowed to CLIENT profile",
                            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
            })
    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ClientResponseDto> findById(@PathVariable Long id) {
        Client client = clientService.findById(id);
        return ResponseEntity.ok(ClientMapper.toDto(client));
    }


    @Operation(summary = "Retrieve list of clients",
            description = "Request requires the use of a bearer token. Access restricted to Role='ADMIN' ",
            security = @SecurityRequirement(name = "security"),
            parameters = {
                    @Parameter(in = QUERY, name = "page",
                            content = @Content(schema = @Schema(type = "integer", defaultValue = "0")),
                            description = "Represents the page returned"
                    ),
                    @Parameter(in = QUERY, name = "size",
                            content = @Content(schema = @Schema(type = "integer", defaultValue = "5")),
                            description = "Represents the total number of elements per page"
                    ),
                    @Parameter(in = QUERY, name = "sort", hidden = true,
                            array = @ArraySchema(schema = @Schema(type = "string", defaultValue = "nome,asc")),
                            description = "Represents the ordering of the results. Multiple ordering criteria are supported.")
            },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Resource retrieved successfully",
                            content = @Content(mediaType = " application/json;charset=UTF-8",
                                    schema = @Schema(implementation = ClientResponseDto.class))
                    ),
                    @ApiResponse(responseCode = "403", description = "Resource not allowed for the CLIENT profile",
                            content = @Content(mediaType = " application/json;charset=UTF-8",
                                    schema = @Schema(implementation = ErrorMessage.class))
                    )
            })
    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<PageableDto> findAll(@Parameter(hidden = true) @PageableDefault(size = 5, sort = {"name"}) Pageable pageable) {
        Page<ClientProjection> clients = clientService.findAll(pageable);
        return ResponseEntity.ok(PageableMapper.toDto(clients));
    }


    @Operation(summary = "Retrive a authenticated client",
            description = "Request requires the use of a bearer token. Access restricted to Role='CLIENT'",
            security = @SecurityRequirement(name = "security"),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Resource retrieved successfully",
                            content = @Content(mediaType = " application/json;charset=UTF-8",
                                    schema = @Schema(implementation = ClientResponseDto.class))
                    ),
                    @ApiResponse(responseCode = "403", description = "Resource not allowed for the ADMIN profile",
                            content = @Content(mediaType = " application/json;charset=UTF-8",
                                    schema = @Schema(implementation = ErrorMessage.class))
                    )
            })
    @GetMapping("/details")
    @PreAuthorize("hasRole('CLIENT')")
    public ResponseEntity<ClientResponseDto> findDetails(@AuthenticationPrincipal JwtUserDetails userDetails) {
        Client client = clientService.findByUserId(userDetails.getId());
        return ResponseEntity.ok(ClientMapper.toDto(client));
    }
}
