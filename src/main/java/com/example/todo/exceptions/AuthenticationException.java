package com.example.todo.exceptions;


public class AuthenticationException extends Exception {

    public AuthenticationException() {}

    public AuthenticationException(String errorMessage) {
        super(errorMessage);
    }
}
