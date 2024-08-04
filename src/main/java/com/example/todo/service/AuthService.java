package com.example.todo.service;

import com.example.todo.dto.JwtRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface AuthService {
    ResponseEntity<?> createAuthToken(@RequestBody JwtRequest authRequest);
}
