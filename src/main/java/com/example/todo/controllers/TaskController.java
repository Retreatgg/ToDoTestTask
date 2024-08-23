package com.example.todo.controllers;

import com.example.todo.dtos.TaskChangeProcess;
import com.example.todo.dtos.TaskCreateDto;
import com.example.todo.dtos.TaskDto;
import com.example.todo.dtos.TaskEditDto;
import com.example.todo.models.Task;
import com.example.todo.services.TaskService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<TaskDto>> getTasksByAuthorId(
            @PathVariable Long id,
            @RequestParam(name = "status", defaultValue = "default") String status,
//            @RequestParam(name = "priority", defaultValue = "default") String priority,
            @RequestParam(name = "page", defaultValue = "0") Integer page,
            @RequestParam(name = "size", defaultValue = "5") Integer size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(taskService.getTasksByAuthorId(id, status, pageable));
    }
//
//    @GetMapping("/performer/{id}")
//    public ResponseEntity<List<TaskDto>> getTasksByPerformerId(
//            @PathVariable Long id,
//            @RequestParam(name = "status", defaultValue = "default") String status,
//            @RequestParam(name = "priority", defaultValue = "default") String priority,
//            @RequestParam(name = "page", defaultValue = "0") Integer page,
//            @RequestParam(name = "size", defaultValue = "5") Integer size
//    ) {
//        Pageable pageable = PageRequest.of(page, size);
//        return ResponseEntity.ok(taskService.getTasksByPerformerId(id, status, priority, pageable));
//    }

    @PostMapping("")
    @CrossOrigin(origins = "http://localhost:3000")
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
                                      @RequestBody @Valid TaskChangeProcess taskChangeProcess) {
        taskService.changeProcess(id, taskChangeProcess);
        return HttpStatus.OK;
    }

    @DeleteMapping("{id}")
    @CrossOrigin(origins = "http://localhost:3000")
    public HttpStatus delete(@PathVariable Task id) {
        taskService.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping("{id}")
    public ResponseEntity<TaskDto> getTaskById(@PathVariable(name = "id") Task task) {
        return ResponseEntity.ok(taskService.getTaskDto(task));
    }
}
