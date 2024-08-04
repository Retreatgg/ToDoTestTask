package com.example.todo.services;

import com.example.todo.dtos.JwtRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface AuthService {
    ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest);
}
