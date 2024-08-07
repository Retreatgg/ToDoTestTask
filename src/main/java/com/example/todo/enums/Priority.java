package com.example.todo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.NoSuchElementException;

@Getter
@RequiredArgsConstructor
public enum Priority {
    LOW("НИЗКИЙ"), HIGH("ВЫСОКИЙ"), MIDDLE("СРЕДНИЙ");

    private final String priority;

    public static Priority getPriority(String priority) {
        return switch (priority.toUpperCase()) {
            case "НИЗКИЙ" -> LOW;
            case "ВЫСОКИЙ" -> HIGH;
            case "СРЕДНИЙ" -> MIDDLE;
            default -> throw new NoSuchElementException(String.format("No such status: '%s'", priority));
        };
    }

    @Override
    public String toString() {
        return priority;
    }
}
