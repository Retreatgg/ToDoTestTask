package com.example.todo.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JwtRequest {
    @Email
    @NotNull
    private String email;
    @NotNull
    private String password;
}
