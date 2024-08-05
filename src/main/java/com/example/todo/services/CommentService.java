package com.example.todo.services;

import com.example.todo.dtos.CommentCreateDto;
import com.example.todo.dtos.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    void create(CommentCreateDto createDto, Long taskId);

    List<CommentDto> getCommentsByTaskId(Long taskId);
}
