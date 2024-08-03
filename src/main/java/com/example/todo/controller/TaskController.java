package com.example.todo.controller;

import com.example.todo.dto.TaskCreateDto;
import com.example.todo.dto.TaskDto;
import com.example.todo.dto.TaskEditDto;
import com.example.todo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("")
    public ResponseEntity<List<TaskDto>> getTasks() {
        return ResponseEntity.ok(taskService.getTasksByAuthorId(1L));
    }

    @PostMapping("")
    public HttpStatus create(@RequestBody TaskCreateDto createDto) {
        taskService.create(createDto);
        return HttpStatus.OK;
    }

    @PutMapping
    public HttpStatus edit(@RequestBody TaskEditDto editDto) {
        taskService.edit(editDto);
        return HttpStatus.OK;
    }
}
