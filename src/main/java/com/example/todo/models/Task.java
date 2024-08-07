package com.example.todo.models;

import com.example.todo.enums.Priority;
import com.example.todo.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "tasks")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "performer_id", nullable = false)
    private User performer;

    @Size(max = 150)
    @NotNull
    @Column(name = "name_task", nullable = false, length = 150)
    private String nameTask;

    @Size(max = 255)
    @NotNull
    @Column(name = "description", nullable = false)
    private String description;

    @Size(max = 35)
    @NotNull
    @Column(name = "status", nullable = false, length = 35)
    private String status;

    @Size(max = 35)
    @NotNull
    @Column(name = "priority", nullable = false, length = 35)
    private String priority;

    @NotNull
    @Column(name = "created_date", nullable = false)
    private Instant createdDate;

    @NotNull
    @Column(name = "updated_date", nullable = false)
    private Instant updatedDate;

    @NotNull
    @ColumnDefault("false")
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = false;

}