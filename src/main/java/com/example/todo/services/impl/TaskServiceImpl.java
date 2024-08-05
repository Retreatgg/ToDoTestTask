package com.example.todo.services.impl;

import com.example.todo.dtos.*;
import com.example.todo.enums.Status;
import com.example.todo.exceptions.AuthenticationException;
import com.example.todo.exceptions.TaskNotFoundException;
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
    private final UserService userService;

    @Override
    public List<TaskDto> getTasksByAuthorId(Long authorId) {
        Specification<Task> spec = TaskSpecification.hasAuthor(authorId);
        List<Task> tasks = taskRepository.findAll(spec);
        return tasks.stream()
                .map(TaskServiceImpl::taskDto)
                .toList();
    }

    @Override
    public void create(TaskCreateDto createDto) {
        User author = AuthUtils.getUserByAuth();
        Task task = createModel(createDto, author);
        taskRepository.save(task);
        log.info("User {} create new task", author.getId());
    }

    @Override
    public void edit(TaskEditDto editDto, Long taskId) {
        User author = AuthUtils.getUserByAuth();
        Task task = updateModel(editDto, taskId);
        taskRepository.save(task);
        log.info("user {} updated task {}", author.getId(), task.getId());
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with ID: "+id+" not found"));
    }

    @Override
    public void changePerformer(Long id, TaskChangePerformerDto taskChangePerformerDto) {
        Task task = findById(id);
        task.setPerformer(userService.findById(taskChangePerformerDto.getPerformerId()));
        taskRepository.save(task);
        log.info("Task {} was change performer {}", id, taskChangePerformerDto.getPerformerId());
    }

    @Override
    public void changeStatus(Long id, TaskChangeStatusDto taskChangeStatusDto) {
        Task task = findById(id);
        task.setStatus(Status.valueOf(taskChangeStatusDto.getStatus()));
        taskRepository.save(task);
        log.info("Task {} was change status {}", id, taskChangeStatusDto.getStatus());
    }

    @Override
    public List<TaskDto> getTasksByPerformerId(Long id) {
        Specification<Task> spec = TaskSpecification.hasPerformer(id);
        List<Task> tasks = taskRepository.findAll(spec);
        return tasks.stream()
                .map(TaskServiceImpl::taskDto)
                .toList();
    }

    @Override
    public void delete(Long id) {
        taskRepository.deleteById(id);
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

    private Task updateModel(TaskEditDto dto, Long taskId) {
        return Task.builder()
                .id(taskId)
                .nameTask(dto.getNameTask())
                .status(dto.getStatus())
                .priority(dto.getPriority())
                .updatedDate(Instant.now())
                .performer(userService.findById(dto.getPerformerId()))
                .description(dto.getDescription())
                .build();
    }

    private static TaskDto taskDto(Task model) {
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

}
