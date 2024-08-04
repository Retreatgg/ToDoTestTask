package com.example.todo.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException() {}
    public UserNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
