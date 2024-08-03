package com.example.todo.service;

import com.example.todo.dto.CommentCreateDto;
import com.example.todo.dto.CommentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    void create(CommentCreateDto createDto);

    List<CommentDto> getCommentsByTaskId(Long taskId);
}
