package com.example.todo.controllers;

import com.example.todo.dtos.TaskCreateDto;
import com.example.todo.dtos.TaskDto;
import com.example.todo.dtos.TaskEditDto;
import com.example.todo.exceptions.AuthenticationException;
import com.example.todo.models.User;
import com.example.todo.services.TaskService;
import com.example.todo.utils.AuthUtils;
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

    @GetMapping("")
    public ResponseEntity<List<TaskDto>> getTasks() {
        User user = AuthUtils.getUserByAuth();
        return ResponseEntity.ok(taskService.getTasksByAuthorId(user.getId()));
    }

    @PostMapping("")
    public HttpStatus create(@RequestBody @Valid TaskCreateDto createDto){
        taskService.create(createDto);
        return HttpStatus.OK;
    }

    @PutMapping("{id}")
    public HttpStatus edit(@PathVariable Long id, @RequestBody @Valid TaskEditDto editDto) {
        taskService.edit(editDto, id);
        return HttpStatus.OK;
    }
}
