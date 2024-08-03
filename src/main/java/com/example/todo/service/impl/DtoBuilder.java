package com.example.todo.service.impl;

import com.example.todo.dto.CommentDto;
import com.example.todo.dto.TaskDto;
import com.example.todo.dto.UserDto;
import com.example.todo.model.Comment;
import com.example.todo.model.Task;
import com.example.todo.model.User;
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

    public UserDto userDto(User model) {
        return UserDto.builder().build();
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
