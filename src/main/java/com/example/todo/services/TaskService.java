package com.example.todo.services;

import com.example.todo.dtos.TaskCreateDto;
import com.example.todo.dtos.TaskDto;
import com.example.todo.dtos.TaskEditDto;
import com.example.todo.exceptions.AuthenticationException;
import com.example.todo.models.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    List<TaskDto> getTasksByAuthorId(Long authorId);

    void create(TaskCreateDto createDto);

    void edit(TaskEditDto editDto, Long taskId);
    Task findById(Long id);
}
