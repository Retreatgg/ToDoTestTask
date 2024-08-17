package com.example.todo.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
public class TaskCreateDto {

//    private Long performerId;
    private String nameTask;
    private String description;
    private String status;
//    private String priority;
    private String sticker;
    private String startTime;
    private String endTime;
    private Integer process;
    private Instant date;

}
