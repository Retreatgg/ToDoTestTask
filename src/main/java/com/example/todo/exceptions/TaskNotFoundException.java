package com.example.todo.exceptions;

import java.util.NoSuchElementException;

public class TaskNotFoundException extends NoSuchElementException {
    public TaskNotFoundException() {}

    public TaskNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
