package com.example.todo.service.impl;

import com.example.todo.repository.TaskRepository;
import com.example.todo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

}
