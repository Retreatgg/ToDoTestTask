package com.example.todo.service.impl;

import com.example.todo.repository.CommentRepository;
import com.example.todo.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
}
