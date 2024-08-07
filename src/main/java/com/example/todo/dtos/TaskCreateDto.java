package com.example.todo.dtos;

import com.example.todo.enums.Priority;
import com.example.todo.enums.Status;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskCreateDto {

    @NotNull
    private Long performerId;
    @NotEmpty
    private String nameTask;
    @NotEmpty
    private String description;
    @NotNull
    private String status;
    @NotNull
    private String priority;

}
