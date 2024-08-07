package com.example.todo.services.impl;

import com.example.todo.dtos.CommentCreateDto;
import com.example.todo.dtos.CommentDto;
import com.example.todo.models.Comment;
import com.example.todo.models.Task;
import com.example.todo.models.User;
import com.example.todo.repositories.CommentRepository;
import com.example.todo.services.CommentService;
import com.example.todo.utils.AuthUtils;
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
    private final AuthUtils authUtils;

    @Override
    public void create(CommentCreateDto createDto, Task task) {
        User user = authUtils.getUserByAuth();
        Comment comment = createModel(createDto, user, task);
        commentRepository.save(comment);
        log.info("User {} write comment for task {}", comment.getAuthor().getId(), task.getId());
    }

    @Override
    public List<CommentDto> getCommentsByTaskId(Long taskId) {
        return commentRepository.findByTaskId(taskId)
                .stream()
                .map(CommentServiceImpl::commentDto)
                .toList();
    }

    private Comment createModel(CommentCreateDto dto, User author, Task task) {
        return Comment.builder()
                .createdDate(Instant.now())
                .description(dto.getDescription())
                .author(author)
                .task(task)
                .build();
    }

    private static CommentDto commentDto(Comment model) {
        return CommentDto.builder()
                .authorId(model.getAuthor().getId())
                .createdDate(model.getCreatedDate())
                .taskId(model.getTask().getId())
                .description(model.getDescription())
                .id(model.getId())
                .build();
    }
}
