package com.example.todo.services;

import com.example.todo.dtos.*;
import com.example.todo.models.Task;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    List<TaskDto> getTasksByAuthorId(Long authorId, String status, String priority, Pageable pageable);

    void create(TaskCreateDto createDto);

    void edit(TaskEditDto editDto, Long taskId);
    Task findById(Long id);

    void changePerformer(Long id, TaskChangePerformerDto taskChangePerformerDto);

    void changeStatus(Long id, TaskChangeStatusDto taskChangeStatusDto);

    List<TaskDto> getTasksByPerformerId(Long id, String status, String priority, Pageable pageable);

    void delete(Task task);

    TaskDto getTaskDto(Task task);
}


