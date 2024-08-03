package com.example.todo.service.impl;

import com.example.todo.model.User;
import com.example.todo.repository.UserRepository;
import com.example.todo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }
}
