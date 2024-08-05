package com.example.todo.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskChangeStatusDto {
    @NotNull
    private String status;
}
