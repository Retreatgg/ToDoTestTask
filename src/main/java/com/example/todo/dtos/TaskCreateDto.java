package com.example.todo.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@Builder
public class TaskCreateDto {

    @NotNull
    private String nameTask;
    @NotNull
    private String description;
    @NotNull
    private String status;
    @NotNull
    private String sticker;
    @NotNull
    private String startTime;
    @NotNull
    private String endTime;
    @NotNull
    private Instant date;

}
