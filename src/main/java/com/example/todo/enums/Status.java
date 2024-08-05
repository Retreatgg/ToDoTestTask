package com.example.todo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.NoSuchElementException;
@Getter
@RequiredArgsConstructor
public enum Status {
    NEW("НОВЫЙ"), PENDING("В ОЖИДАНИИ"), IN_PROGRESS("В ПРОГРЕССЕ"), DONE("СДЕЛАНА");

    private final String status;

    public static Status getStatusEnum(String status) {
        return switch (status.toUpperCase()) {
            case "НОВЫЙ" -> NEW;
            case "В ПРОГРЕССЕ" -> IN_PROGRESS;
            case "СДЕЛАНА" -> DONE;
            case "В ОЖИДАНИИ" -> PENDING;
            default -> throw new NoSuchElementException(String.format("No such status: '%s'", status));
        };
    }

    @Override
    public String toString() {
        return status;
    }
}
