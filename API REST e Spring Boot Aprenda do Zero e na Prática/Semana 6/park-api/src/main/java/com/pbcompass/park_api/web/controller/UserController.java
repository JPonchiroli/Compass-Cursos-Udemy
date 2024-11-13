package com.pbcompass.park_api.web.controller;

import com.pbcompass.park_api.web.dto.UserCreateDto;
import com.pbcompass.park_api.web.dto.UserPasswordDto;
import com.pbcompass.park_api.web.dto.UserResponseDto;
import com.pbcompass.park_api.web.dto.mapper.UserMapper;
import com.pbcompass.park_api.web.exception.ErrorMessage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pbcompass.park_api.entities.User;
import com.pbcompass.park_api.services.UserService;

import java.util.List;

    @Tag(name = "Users", description = "It has all the operations related to the insertion, editing and display resources of a user")
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @Operation(summary = "Insert a new User", description = "Resource to create a new user",
        responses = {
            @ApiResponse(responseCode = "201", description = "Resource created successfully",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserResponseDto.class))),
            @ApiResponse(responseCode = "409", description = "User e-mail already registered in the system",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class))),
            @ApiResponse(responseCode = "422", description = "Resource not processed buy wrong data entry",
                content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorMessage.class)))
    })
    @PostMapping
    public ResponseEntity<UserResponseDto> insert(@Valid @RequestBody UserCreateDto createDto) {
        User newUser = userService.save(UserMapper.toUser(createDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UserMapper.toDto(newUser));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAll(){
        List<User> users = userService.findAll();
        return ResponseEntity.ok(UserMapper.toListDto(users));
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(UserMapper.toDto(user));
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Void> updatePassword(@Valid @PathVariable Long id, @RequestBody UserPasswordDto userDto) {
        User currentUser = userService.updatePassword(id, userDto.getCurrentPassword(), userDto.getNewPassword(), userDto.getConfirmPassword());
        return ResponseEntity.noContent().build();
    }
}
