package com.example.todo.dtos;

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
    private Integer process;
    @NotNull
    private String status;
    @NotNull
    private String priority;

}
