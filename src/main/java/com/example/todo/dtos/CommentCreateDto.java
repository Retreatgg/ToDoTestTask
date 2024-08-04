package com.example.todo.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentCreateDto {

    private Long authorId;
    private String description;
    private Long taskId;
}
