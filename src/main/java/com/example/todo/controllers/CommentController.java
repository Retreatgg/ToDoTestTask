package com.example.todo.controllers;

import com.example.todo.dtos.CommentCreateDto;
import com.example.todo.dtos.CommentDto;
import com.example.todo.services.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tasks/{taskId}/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    public HttpStatus create(@PathVariable Long taskId,  @RequestBody @Valid CommentCreateDto createDto) {
        commentService.create(createDto, taskId);
        return HttpStatus.OK;
    }

    @GetMapping
    public ResponseEntity<List<CommentDto>> getComments(@PathVariable Long taskId) {
        return ResponseEntity.ok(commentService.getCommentsByTaskId(taskId));
    }
}
