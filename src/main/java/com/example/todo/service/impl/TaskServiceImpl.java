package com.example.todo.service.impl;

import com.example.todo.dto.TaskCreateDto;
import com.example.todo.dto.TaskDto;
import com.example.todo.dto.TaskEditDto;
import com.example.todo.model.Task;
import com.example.todo.repository.TaskRepository;
import com.example.todo.service.TaskService;
import com.example.todo.service.UserService;
import com.example.todo.specifications.TaskSpecification;
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
    public void create(TaskCreateDto createDto) {
        Task task = createModel(createDto);
        taskRepository.save(task);
        log.info("user {} create new task", 1);
    }

    @Override
    public void edit(TaskEditDto editDto) {
        Task task = updateModel(editDto);
        taskRepository.save(task);
        log.info("user {} updated task {}", 1, 2);
    }

    private Task createModel(TaskCreateDto dto) {
        return Task.builder()
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
