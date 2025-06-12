package com.demo.userservice.controller;

import com.demo.userservice.request.CreateUserRequest;
import com.demo.userservice.response.CreatedUserResponse;
import com.demo.userservice.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<CreatedUserResponse> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
        CreatedUserResponse userResponse = userService.createUser(createUserRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

}