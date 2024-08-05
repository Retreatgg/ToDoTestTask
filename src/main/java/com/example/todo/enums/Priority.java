package com.example.todo.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Priority {
    LOW("НИЗКИЙ"), HIGH("ВЫСОКИЙ"), MIDDLE("НИЗКИЙ");

    private final String priority;

    @Override
    public String toString() {
        return priority;
    }
}
