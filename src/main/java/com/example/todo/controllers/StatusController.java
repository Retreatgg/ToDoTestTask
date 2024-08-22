package com.example.todo.controllers;

import com.example.todo.enums.Status;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/statuses")
public class StatusController {

    @GetMapping("")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<String>> getStatuses() {
        List<String> statuses = Arrays.stream(Status.values())
                .map(Status::toString)
                .toList();
        return ResponseEntity.ok(statuses);
    }
}
