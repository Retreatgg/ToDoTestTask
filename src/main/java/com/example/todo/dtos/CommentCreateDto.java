package com.example.todo.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentCreateDto {

    @NotEmpty
    private String description;
    @NotNull
    private Long taskId;
}
