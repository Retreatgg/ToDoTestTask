package com.example.todo.service.impl;

import com.example.todo.model.Authority;
import com.example.todo.repository.AuthorityRepository;
import com.example.todo.service.AuthorityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {
    private final AuthorityRepository authorityRepository;

    @Override
    public Authority findById(Long id) {
        return authorityRepository.findById(id).orElseThrow();
    }
}
