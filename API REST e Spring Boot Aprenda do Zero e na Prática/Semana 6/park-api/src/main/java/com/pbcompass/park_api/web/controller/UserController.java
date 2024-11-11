package com.pbcompass.park_api.web.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pbcompass.park_api.entities.User;
import com.pbcompass.park_api.services.UserService;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user) {
        User newUser = userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}
