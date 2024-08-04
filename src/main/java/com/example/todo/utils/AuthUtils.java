package com.example.todo.utils;

import com.example.todo.exceptions.AuthenticationException;
import com.example.todo.models.User;
import com.example.todo.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class AuthUtils {

    private static UserService userService;

    public static User getUserByAuth() throws AuthenticationException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null) throw new AuthenticationException("Контекст пустой");
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String email = userDetails.getUsername();
        return userService.findByEmail(email);
    }
}
