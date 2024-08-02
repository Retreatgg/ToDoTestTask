package com.example.todo.service;

import com.example.todo.dto.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

    List<TaskDto> getTasksByAuthorId(Long authorId);
}
