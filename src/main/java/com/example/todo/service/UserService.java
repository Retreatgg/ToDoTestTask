package com.example.todo.service;

import com.example.todo.model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserService {

    User findById(Long id);
    Optional<User> findByEmail(String email);
}
