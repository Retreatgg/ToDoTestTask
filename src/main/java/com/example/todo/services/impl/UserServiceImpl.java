package com.example.todo.services.impl;

import com.example.todo.dtos.RegisterUserDto;
import com.example.todo.exceptions.AuthenticationException;
import com.example.todo.exceptions.UserNotFoundException;
import com.example.todo.models.User;
import com.example.todo.models.UserAuthority;
import com.example.todo.repositories.UserAuthorityRepository;
import com.example.todo.repositories.UserRepository;
import com.example.todo.services.AuthorityService;
import com.example.todo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserAuthorityRepository userAuthorityRepository;
    private final AuthorityService authorityService;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException("not found"));
    }

    @Override
    public void create(RegisterUserDto userDto) {
        if(isRegister(userDto.getEmail())) {
            throw new AuthenticationException("user is registered");
        }
        User user = createModel(userDto);
        userRepository.save(user);
        UserAuthority userAuthority=  UserAuthority.builder()
                .user(user)
                .authority(authorityService.findById(1L))
                .build();
        userAuthorityRepository.save(userAuthority);
    }

    private User createModel(RegisterUserDto userDto) {
        return User.builder()
                .enabled(true)
                .password(passwordEncoder.encode(userDto.getPassword()))
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .build();
    }

    private Boolean isRegister(String email) {
        Optional<User> optional = userRepository.findByEmail(email);
        return optional.isPresent();
    }
}
