package com.example.todo.exceptions;

import java.util.NoSuchElementException;

public class UserNotFoundException extends NoSuchElementException {
    public UserNotFoundException() {}
    public UserNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
