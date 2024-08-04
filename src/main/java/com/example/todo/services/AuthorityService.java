package com.example.todo.services;

import com.example.todo.models.Authority;
import org.springframework.stereotype.Service;

@Service
public interface AuthorityService {

    Authority findById(Long id);
}
