package com.example.todo.exceptions;


public class AuthenticationException extends IllegalArgumentException {

    public AuthenticationException() {}

    public AuthenticationException(String errorMessage) {
        super(errorMessage);
    }
}
