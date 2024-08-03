package com.example.todo.service;

import com.example.todo.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User findById(Long id);
}
