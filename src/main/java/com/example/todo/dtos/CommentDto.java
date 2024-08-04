package com.example.todo.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;

@Data
@Builder
public class CommentDto {

    private Long id;
    private Long authorId;
    private String description;
    private Instant createdDate;
    private Long taskId;

}
