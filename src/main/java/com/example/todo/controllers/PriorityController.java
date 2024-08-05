package com.example.todo.controllers;

import com.example.todo.enums.Priority;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/priorities")
public class PriorityController {

    @GetMapping
    public ResponseEntity<List<String>> getPriorities() {
        List<String> priorities = Arrays.stream(Priority.values())
                .map(Priority::toString)
                .toList();
        return ResponseEntity.ok(priorities);
    }
}
