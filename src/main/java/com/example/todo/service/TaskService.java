package com.example.todo.service;

import com.example.todo.dto.TaskCreateDto;
import com.example.todo.dto.TaskDto;
import com.example.todo.dto.TaskEditDto;
import com.example.todo.model.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    List<TaskDto> getTasksByAuthorId(Long authorId);

    void create(TaskCreateDto createDto);

    void edit(TaskEditDto editDto);
    Task findById(Long id);
}
