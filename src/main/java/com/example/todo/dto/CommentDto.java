package com.example.todo.dto;

import com.example.todo.model.Task;
import com.example.todo.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
