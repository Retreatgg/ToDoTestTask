package com.example.todo.dto;

import com.example.todo.enums.Priority;
import com.example.todo.enums.Status;
import com.example.todo.model.User;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskDto {

    private Long id;
    private UserDto author;
    private UserDto performer;
    private String nameTask;
    private String description;
    private Status status;
    private Priority priority;
}
