package com.example.todo.dtos;

import lombok.Data;

@Data
public class JwtRequest {
    private String email;
    private String password;
}
