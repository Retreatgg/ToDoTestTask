package com.example.todo.dto;

import com.example.todo.enums.Priority;
import com.example.todo.enums.Status;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskCreateDto {

    private Long performerId;
    private String nameTask;
    private String description;
    private Status status;
    private Priority priority;

}
