package com.example.todo.services.impl;

import com.example.todo.dtos.*;
import com.example.todo.exceptions.TaskNotFoundException;
import com.example.todo.models.Task;
import com.example.todo.models.User;
import com.example.todo.repositories.TaskRepository;
import com.example.todo.services.CommentService;
import com.example.todo.services.TaskService;
import com.example.todo.services.UserService;
import com.example.todo.specifications.TaskSpecification;
import com.example.todo.utils.AuthUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    private final CommentService commentService;
    private final AuthUtils authUtils;

    @Override
    public List<TaskDto> getTasksByAuthorId(Long authorId, String status, String priority, Pageable pageable) {
        Specification<Task> spec = TaskSpecification.hasAuthor(authorId)
                .and(TaskSpecification.hasStatus(status))
                .and(TaskSpecification.hasPriority(priority))
                .and(TaskSpecification.hasActive(true));
        Page<Task> tasks = taskRepository.findAll(spec, pageable);
        return tasks.getContent().stream()
                .map(task -> taskDto(task, commentService))
                .toList();
    }

    @Override
    public void create(TaskCreateDto createDto) {
        User author = authUtils.getUserByAuth();
        Task task = createModel(createDto, author);
        taskRepository.save(task);
        log.info("User {} create new task", author.getId());
    }

    @Override
    public void edit(TaskEditDto editDto, Long taskId) {
        User author = authUtils.getUserByAuth();
        Task task = updateModel(editDto, taskId);
        taskRepository.save(task);
        log.info("user {} updated task {}", author.getId(), task.getId());
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new TaskNotFoundException("Task with ID: " + id + " was not found. Please verify the ID and try again."));
    }

    @Override
    public void changePerformer(Long id, TaskChangePerformerDto taskChangePerformerDto) {
        Task task = findById(id);
        Long authorId = authUtils.getUserByAuth().getId();
        if (authorId == task.getAuthor().getId()) {
            task.setPerformer(userService.findById(taskChangePerformerDto.getPerformerId()));
            taskRepository.save(task);
            log.info("Task {} was change performer {}", id, taskChangePerformerDto.getPerformerId());
        } else {
            throw new IllegalArgumentException("You do not have permission to change the performer for this task. Only the author can change the performer.");
        }
    }

    @Override
    public void changeStatus(Long id, TaskChangeStatusDto taskChangeStatusDto) {
        Task task = findById(id);
        Long authUserId = authUtils.getUserByAuth().getId();
        if (task.getPerformer().getId() == authUserId || authUserId == task.getAuthor().getId()) {
            task.setStatus(taskChangeStatusDto.getStatus());
            taskRepository.save(task);
            log.info("Task {} was change status {}", id, taskChangeStatusDto.getStatus());
        } else {
            throw new IllegalArgumentException("You do not have permission to change the status of this task. Only the performer or author can change the status.");
        }

    }

    @Override
    public List<TaskDto> getTasksByPerformerId(Long id, String status, String priority, Pageable pageable) {
        Specification<Task> spec = TaskSpecification.hasPerformer(id)
                .and(TaskSpecification.hasStatus(status))
                .and(TaskSpecification.hasPriority(priority))
                .and(TaskSpecification.hasActive(true));
        Page<Task> tasks = taskRepository.findAll(spec, pageable);
        return tasks.getContent().stream()
                .map(task -> taskDto(task, commentService))
                .toList();
    }

    @Override
    public void delete(Task task) {
        User user = authUtils.getUserByAuth();
        if (!task.getAuthor().equals(user)) {
            throw new IllegalArgumentException("You do not have permission to delete this task. Only the author can delete it.");
        }
        task.setIsActive(false);
        taskRepository.save(task);
        log.info("Task {} was deleted", task.getId());
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

    private static TaskDto taskDto(Task model, CommentService comService) {
        List<CommentDto> comments = comService.getCommentsByTaskId(model.getId());
        return TaskDto.builder()
                .id(model.getId())
                .description(model.getDescription())
                .nameTask(model.getNameTask())
                .authorId(model.getAuthor().getId())
                .performerId(model.getAuthor().getId())
                .status(model.getStatus())
                .priority(model.getPriority())
                .commentDtoList(comments)
                .build();
    }

}
