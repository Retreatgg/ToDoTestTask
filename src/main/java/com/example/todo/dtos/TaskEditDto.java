package com.example.todo.dtos;

import com.example.todo.enums.Priority;
import com.example.todo.enums.Status;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskEditDto {
    @NotNull
    private Long performerId;
    @NotNull
    private String nameTask;
    @NotNull
    private String description;
    @NotNull
    private Status status;
    @NotNull
    private Priority priority;

}
