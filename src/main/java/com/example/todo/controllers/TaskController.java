package com.example.todo.controllers;

import com.example.todo.dtos.*;
import com.example.todo.models.Task;
import com.example.todo.services.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
@Slf4j
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/author/{id}")
    public ResponseEntity<List<TaskDto>> getTasksByAuthorId(
            @PathVariable Long id,
            @RequestParam(name = "status", defaultValue = "default") String status,
            @RequestParam(name = "priority", defaultValue = "default") String priority
    ) {
        return ResponseEntity.ok(taskService.getTasksByAuthorId(id, status, priority));
    }

    @GetMapping("/performer/{id}")
    public ResponseEntity<List<TaskDto>> getTasksByPerformerId(
            @PathVariable Long id,
            @RequestParam(name = "status") String status,
            @RequestParam(name = "priority") String priority
    ) {
        return ResponseEntity.ok(taskService.getTasksByPerformerId(id, status, priority));
    }

    @PostMapping("")
    public HttpStatus create(@RequestBody @Valid TaskCreateDto createDto) {
        taskService.create(createDto);
        return HttpStatus.OK;
    }

    @PutMapping("{id}")
    public HttpStatus edit(@PathVariable Long id, @RequestBody @Valid TaskEditDto editDto) {
        taskService.edit(editDto, id);
        return HttpStatus.OK;
    }

    @PatchMapping("{id}")
    public HttpStatus changePerformer(@PathVariable Long id,
                                      @RequestBody @Valid TaskChangePerformerDto taskChangePerformerDto) {
        taskService.changePerformer(id, taskChangePerformerDto);
        return HttpStatus.OK;
    }

    @DeleteMapping("{id}")
    public HttpStatus delete(@PathVariable Task id) {
        taskService.delete(id);
        return HttpStatus.OK;
    }
}
