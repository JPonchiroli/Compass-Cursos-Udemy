package com.pbcompass.park_api.web.controller;

import com.pbcompass.park_api.entities.Client;
import com.pbcompass.park_api.jwt.JwtUserDetails;
import com.pbcompass.park_api.services.ClientService;
import com.pbcompass.park_api.services.UserService;
import com.pbcompass.park_api.web.dto.ClientCreateDto;
import com.pbcompass.park_api.web.dto.ClientResponseDto;
import com.pbcompass.park_api.web.dto.UserResponseDto;
import com.pbcompass.park_api.web.dto.mapper.ClientMapper;
import com.pbcompass.park_api.web.exception.ErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/clients")
public class ClientController {

    private final ClientService clientService;
    private final UserService userService;

    @Operation(summary = "Insert a new Client", description = "Resource to create a new client liked with a user. " +
            "The request requires a Bearer Token. Access restricted to CLIENT",
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
                                                    @AuthenticationPrincipal JwtUserDetails userDetails){
        Client client = ClientMapper.toClient(dto);
        client.setUser(userService.findById(userDetails.getId()));
        clientService.insert(client);
        return ResponseEntity.status(201).body(ClientMapper.toDto(client));
    }

    @Operation(summary = "Locale a Client", description = "Resource to locale a client by id. " +
            "The request requires a Bearer Token. Access restricted to ADMIN",
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
    public ResponseEntity<ClientResponseDto> findById(@PathVariable Long id){
        Client client = clientService.findById(id);
        return ResponseEntity.ok(ClientMapper.toDto(client));
    }

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Page<Client>> findAll(Pageable pageable){
        Page<Client> clients = clientService.findAll(pageable);
        return ResponseEntity.ok(clients);
    }
}
