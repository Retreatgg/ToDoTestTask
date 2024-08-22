package com.example.todo.controllers;

import com.example.todo.dtos.JwtRequest;
import com.example.todo.dtos.UserRegisterDto;
import com.example.todo.services.AuthService;
import com.example.todo.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final UserService userService;

    @PostMapping()
    public ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest) {
        return authService.createAuthToken(authRequest);
    }

    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:3000")
    public HttpStatus registerUser(@RequestBody @Valid UserRegisterDto userDto) {
        userService.create(userDto);
        return HttpStatus.OK;
    }
}
