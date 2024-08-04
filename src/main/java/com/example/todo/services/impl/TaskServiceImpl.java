package com.example.todo.services.impl;

import com.example.todo.dtos.TaskCreateDto;
import com.example.todo.dtos.TaskDto;
import com.example.todo.dtos.TaskEditDto;
import com.example.todo.exceptions.AuthenticationException;
import com.example.todo.models.Task;
import com.example.todo.models.User;
import com.example.todo.repositories.TaskRepository;
import com.example.todo.services.TaskService;
import com.example.todo.services.UserService;
import com.example.todo.specifications.TaskSpecification;
import com.example.todo.utils.AuthUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final DtoBuilder dtoBuilder;
    private final UserService userService;

    @Override
    public List<TaskDto> getTasksByAuthorId(Long authorId) {
        Specification<Task> spec = TaskSpecification.hasAuthor(authorId);
        List<Task> tasks = taskRepository.findAll(spec);
        return tasks.stream()
                .map(dtoBuilder::taskDto)
                .toList();
    }

    @Override
    public void create(TaskCreateDto createDto) throws AuthenticationException {
        User author = AuthUtils.getUserByAuth();
        Task task = createModel(createDto, author);
        taskRepository.save(task);
        log.info("user {} create new task", 1);
    }

    @Override
    public void edit(TaskEditDto editDto) {
        Task task = updateModel(editDto);
        taskRepository.save(task);
        log.info("user {} updated task {}", 1, 2);
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow();
    }

    private Task createModel(TaskCreateDto dto, User author) {
        return Task.builder()
                .author(author)
                .nameTask(dto.getNameTask())
                .status(dto.getStatus())
                .description(dto.getDescription())
                .priority(dto.getPriority())
                .createdDate(Instant.now())
                .updatedDate(Instant.now())
                .performer(userService.findById(dto.getPerformerId()))
                .build();
    }

    private Task updateModel(TaskEditDto dto) {
        return Task.builder()
                .id(dto.getId())
                .nameTask(dto.getNameTask())
                .status(dto.getStatus())
                .priority(dto.getPriority())
                .updatedDate(Instant.now())
                .performer(userService.findById(dto.getPerformerId()))
                .description(dto.getDescription())
                .build();
    }

}
