package com.example.todo.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class RegisterUserDto {
    @NotEmpty
    private String username;
    @NotEmpty
    @Email
    private String email;

    @NotBlank
    @Size(min = 4, max = 24, message = "Length must be >= 4 and <= 24")
    @Pattern(
            regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).+$",
            message = "Should contain at least one UPPER case letter, one number"
    )
    private String password;
}
