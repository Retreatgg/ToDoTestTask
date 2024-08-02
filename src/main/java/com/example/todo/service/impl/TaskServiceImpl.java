package com.example.todo.service.impl;

import com.example.todo.dto.TaskDto;
import com.example.todo.model.Task;
import com.example.todo.repository.TaskRepository;
import com.example.todo.service.TaskService;
import com.example.todo.specifications.TaskSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final DtoBuilder dtoBuilder;

    @Override
    public List<TaskDto> getTasksByAuthorId(Long authorId) {
        Specification<Task> spec = TaskSpecification.hasAuthor(authorId);
        List<Task> tasks = taskRepository.findAll(spec);
        return tasks.stream()
                .map(dtoBuilder::taskDto)
                .toList();
    }

}
