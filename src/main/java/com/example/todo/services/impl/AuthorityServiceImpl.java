package com.example.todo.services.impl;

import com.example.todo.exceptions.UserNotFoundException;
import com.example.todo.models.Authority;
import com.example.todo.repositories.AuthorityRepository;
import com.example.todo.services.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {
    private final AuthorityRepository authorityRepository;

    @Override
    public Authority findById(Long id) {
        return authorityRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User by ID: " + id + " not found"));
    }
}
