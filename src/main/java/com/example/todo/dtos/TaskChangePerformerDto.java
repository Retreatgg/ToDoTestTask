package com.example.todo.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TaskChangePerformerDto {
    @NotNull
    private Long performerId;
}
