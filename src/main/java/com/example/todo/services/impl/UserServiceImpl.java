package com.example.todo.services.impl;

import com.example.todo.dtos.UserRegisterDto;
import com.example.todo.dtos.UserDto;
import com.example.todo.exceptions.AuthenticationException;
import com.example.todo.exceptions.UserNotFoundException;
import com.example.todo.models.User;
import com.example.todo.models.UserAuthority;
import com.example.todo.repositories.UserAuthorityRepository;
import com.example.todo.repositories.UserRepository;
import com.example.todo.services.AuthorityService;
import com.example.todo.services.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
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
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found with email: " + email));
    }

    @Override
    public UserDto getById(Long id) {
        User user = findById(id);
        return buildDto(user);
    }

    @Override
    public void create(UserRegisterDto userDto) {
        if(isRegister(userDto.getEmail())) {
            throw new AuthenticationException("User already registered");
        }
        User user = createModel(userDto);
        userRepository.save(user);
        UserAuthority userAuthority=  UserAuthority.builder()
                .user(user)
                .authority(authorityService.findById(1L))
                .build();
        userAuthorityRepository.save(userAuthority);
        log.info("Was created new user {}", user.getId());
    }

    private User createModel(UserRegisterDto userDto) {
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

    private UserDto buildDto(User model) {
        return UserDto.builder()
                .id(model.getId())
                .username(model.getUsername())
                .email(model.getEmail())
                .build();
    }
}
