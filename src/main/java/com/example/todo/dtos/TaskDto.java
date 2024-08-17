package com.example.todo.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
public class TaskDto {

    private Long id;
//    private Long authorId;
//    private Long performerId;
    private String nameTask;
    private String description;
    private String status;
    private String sticker;
    private String startTime;
    private String endTime;
    private Integer process;
    private Instant date;

//    List<CommentDto> commentDtoList;

}
