package com.example.todo.service;

import com.example.todo.model.Authority;
import org.springframework.stereotype.Service;

@Service
public interface AuthorityService {

    Authority findById(Long id);
}
