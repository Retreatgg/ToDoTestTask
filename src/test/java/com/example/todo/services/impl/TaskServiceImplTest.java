//package com.example.todo.services.impl;
//
//import com.example.todo.dtos.TaskChangePerformerDto;
//import com.example.todo.dtos.TaskCreateDto;
//import com.example.todo.dtos.TaskDto;
//import com.example.todo.dtos.TaskEditDto;
//import com.example.todo.enums.Priority;
//import com.example.todo.enums.Status;
//import com.example.todo.models.Task;
//import com.example.todo.models.User;
//import com.example.todo.repositories.TaskRepository;
//import com.example.todo.services.CommentService;
//import com.example.todo.services.UserService;
//import com.example.todo.utils.AuthUtils;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentCaptor;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.data.domain.PageImpl;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.domain.Specification;
//
//import java.time.Instant;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Optional;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.eq;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//class TaskServiceImplTest {
//    @InjectMocks
//    private TaskServiceImpl taskService;
//
//    @Mock
//    private TaskRepository taskRepository;
//
//    @Mock
//    private UserService userService;
//
//    @Mock
//    private CommentService commentService;
//
//    @Mock
//    private AuthUtils authUtils;
//
//    private User firstUser;
//    private User secondUser;
//    private Task task1;
//    private Task task2;
//    private Task task3;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//        firstUser = new User();
//        firstUser.setId(1L);
//        firstUser.setUsername("firstUser");
//
//        secondUser = new User();
//        secondUser.setId(2L);
//        secondUser.setUsername("secondUser");
//
//        task1 = Task.builder()
//                .id(1L)
//                .updatedDate(Instant.now())
//                .priority(Priority.LOW.getPriority())
//                .performer(firstUser)
//                .createdDate(Instant.now())
//                .description("Task 1 description")
//                .status(Status.NEW.getStatus())
//                .nameTask("Task 1")
//                .author(secondUser)
//                .isActive(true)
//                .build();
//
//        task2 = Task.builder()
//                .id(2L)
//                .updatedDate(Instant.now())
//                .priority(Priority.MIDDLE.getPriority())
//                .performer(firstUser)
//                .createdDate(Instant.now())
//                .description("Task 2 description")
//                .status(Status.IN_PROGRESS.getStatus())
//                .nameTask("Task 2")
//                .author(firstUser)
//                .isActive(true)
//                .build();
//
//        task3 = Task.builder()
//                .id(3L)
//                .updatedDate(Instant.now())
//                .priority(Priority.HIGH.getPriority())
//                .performer(secondUser)
//                .createdDate(Instant.now())
//                .description("Task 3 description")
//                .status(Status.DONE.getStatus())
//                .nameTask("Task 3")
//                .author(firstUser)
//                .isActive(true)
//                .build();
//    }
//
//    @Test
//    void getTasksByAuthorId_shouldReturnMultipleTasks() {
//        Pageable pageable = Pageable.unpaged();
//        when(taskRepository.findAll(any(Specification.class), eq(pageable)))
//                .thenReturn(new PageImpl<>(Arrays.asList(task2, task3)));
//
//        List<TaskDto> tasks = taskService.getTasksByAuthorId(1L, "default", "default", pageable);
//
//        assertEquals(2, tasks.size());
//        assertEquals(task2.getId(), tasks.get(0).getId());
//        assertEquals(task3.getId(), tasks.get(1).getId());
//    }
//
//    @Test
//    void create() {
//        when(authUtils.getUserByAuth()).thenReturn(firstUser);
//        TaskCreateDto newTask = TaskCreateDto.builder()
//                .priority(Priority.LOW.getPriority())
//                .description("Task 4 description")
//                .status(Status.DONE.getStatus())
//                .nameTask("Task 4")
//                .performerId(2L)
//                .build();
//
//        taskService.create(newTask);
//        ArgumentCaptor<Task> taskCaptor = ArgumentCaptor.forClass(Task.class);
//        verify(taskRepository).save(taskCaptor.capture());
//        assertEquals("Task 4", taskCaptor.getValue().getNameTask());
//    }
//
//    @Test
//    void findById() {
//        when(taskRepository.findById(task1.getId())).thenReturn(Optional.of(task1));
//        Task foundTask = taskService.findById(task1.getId());
//        assertNotNull(foundTask);
//        assertEquals(task1.getId(), foundTask.getId());
//    }
//
//
//
//}