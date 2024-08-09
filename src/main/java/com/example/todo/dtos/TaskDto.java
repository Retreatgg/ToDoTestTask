package com.example.todo.dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TaskDto {

    private Long id;
    private Long authorId;
    private Long performerId;
    private String nameTask;
    private String description;
    private String status;
    private String priority;
    List<CommentDto> commentDtoList;

}
