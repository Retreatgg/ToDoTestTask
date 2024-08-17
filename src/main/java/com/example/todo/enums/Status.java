package com.example.todo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.NoSuchElementException;
@Getter
@RequiredArgsConstructor
public enum Status {
    NEW("NEW"), PENDING("PENDING"), IN_PROGRESS("IN PROGRESS"), DONE("DONE");

    private final String status;

    public static Status getStatusEnum(String status) {
        return switch (status.toUpperCase()) {
            case "NEW" -> NEW;
            case "IN PROGRESS" -> IN_PROGRESS;
            case "DONE" -> DONE;
            case "PENDING" -> PENDING;
            default -> throw new NoSuchElementException(String.format("No such status: '%s'", status));
        };
    }

    @Override
    public String toString() {
        return status;
    }
}
