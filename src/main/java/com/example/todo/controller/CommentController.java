package com.example.todo.controller;

import com.example.todo.dto.CommentCreateDto;
import com.example.todo.dto.CommentDto;
import com.example.todo.service.CommentService;
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
    public HttpStatus create(@PathVariable Long taskId,  @RequestBody CommentCreateDto createDto) {
        createDto.setTaskId(taskId);
        commentService.create(createDto);
        return HttpStatus.OK;
    }

    @GetMapping
    public ResponseEntity<List<CommentDto>> getComments(@PathVariable Long taskId) {
        return ResponseEntity.ok(commentService.getCommentsByTaskId(taskId));
    }
}
