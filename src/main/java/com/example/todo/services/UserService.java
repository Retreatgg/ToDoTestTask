package com.example.todo.services;

import com.example.todo.dtos.RegisterUserDto;
import com.example.todo.dtos.UserDto;
import com.example.todo.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User findById(Long id);
    User findByEmail(String email);
    UserDto getById(Long id);
    void create(RegisterUserDto userDto);
}
