package com.example.todo.services;

import com.example.todo.dtos.CommentCreateDto;
import com.example.todo.dtos.CommentDto;
import com.example.todo.models.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    void create(CommentCreateDto createDto, Task task);

    List<CommentDto> getCommentsByTaskId(Long taskId);
}
