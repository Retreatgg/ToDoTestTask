package com.example.todo.service.impl;

import com.example.todo.dto.TaskDto;
import com.example.todo.dto.UserDto;
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
                .author(userDto(model.getAuthor()))
                .performer(userDto(model.getPerformer()))
                .status(model.getStatus())
                .priority(model.getPriority())
                .build();
    }

    public UserDto userDto(User model) {
        return UserDto.builder().build();
    }
}
