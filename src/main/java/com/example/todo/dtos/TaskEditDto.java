package com.example.todo.dtos;

import com.example.todo.enums.Priority;
import com.example.todo.enums.Status;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskEditDto {

    private Long performerId;
    private String nameTask;
    private String description;
    private Status status;
    private Priority priority;

}
