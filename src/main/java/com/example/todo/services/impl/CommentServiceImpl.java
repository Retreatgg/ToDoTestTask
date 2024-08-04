package com.example.todo.services.impl;

import com.example.todo.dtos.CommentCreateDto;
import com.example.todo.dtos.CommentDto;
import com.example.todo.models.Comment;
import com.example.todo.repositories.CommentRepository;
import com.example.todo.services.CommentService;
import com.example.todo.services.TaskService;
import com.example.todo.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final TaskService taskService;
    private final UserService userService;
    private final DtoBuilder dtoBuilder;

    @Override
    public void create(CommentCreateDto createDto) {
        Comment comment = createModel(createDto);
        commentRepository.save(comment);
        log.info("User {} write comment for task {}", createDto.getAuthorId(), createDto.getTaskId());
    }

    @Override
    public List<CommentDto> getCommentsByTaskId(Long taskId) {
        return commentRepository.findByTaskId(taskId)
                .stream()
                .map(dtoBuilder::commentDto)
                .toList();
    }

    private Comment createModel(CommentCreateDto dto) {
        return Comment.builder()
                .createdDate(Instant.now())
                .description(dto.getDescription())
                .author(userService.findById(dto.getAuthorId()))
                .task(taskService.findById(dto.getAuthorId()))
                .build();
    }
}
