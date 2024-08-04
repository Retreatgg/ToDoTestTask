package com.example.todo.services.impl;

import com.example.todo.dtos.CommentDto;
import com.example.todo.dtos.TaskDto;
import com.example.todo.dtos.UserDto;
import com.example.todo.models.Comment;
import com.example.todo.models.Task;
import com.example.todo.models.User;
import org.springframework.stereotype.Service;

@Service
public class DtoBuilder {

    public TaskDto taskDto(Task model) {
        return TaskDto.builder()
                .id(model.getId())
                .description(model.getDescription())
                .nameTask(model.getDescription())
                .authorId(model.getAuthor().getId())
                .performerId(model.getAuthor().getId())
                .status(model.getStatus())
                .priority(model.getPriority())
                .build();
    }

    public CommentDto commentDto(Comment model) {
        return CommentDto.builder()
                .authorId(model.getAuthor().getId())
                .createdDate(model.getCreatedDate())
                .taskId(model.getTask().getId())
                .description(model.getDescription())
                .id(model.getId())
                .build();
    }
}
