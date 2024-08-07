package com.example.todo.specifications;

import com.example.todo.enums.Priority;
import com.example.todo.enums.Status;
import com.example.todo.models.Task;
import org.springframework.data.jpa.domain.Specification;

public class TaskSpecification {

    public static Specification<Task> hasAuthor(Long authorId) {
        return (r, q, cb) -> {
            if(authorId == null) return cb.conjunction();
            return cb.equal(r.get("author").get("id"), authorId);
        };
    }

    public static Specification<Task> hasPerformer(Long performerId) {
        return (r, q, cb) -> {
            if(performerId == null) return cb.conjunction();
            return cb.equal(r.get("performer").get("id"), performerId);
        };
    }

    public static Specification<Task> hasStatus(String status) {
        return (r, q, cb) -> {
            if(status.equals("default")) return cb.conjunction();
            Status status1 = Status.getStatusEnum(status);
            return cb.equal(r.get("status"), status);
        };
    }

    public static Specification<Task> hasPriority(String priority) {
        return (r, q, cb) -> {
            if(priority.equals("default")) return cb.conjunction();
            Priority priority1 = Priority.getPriority(priority);
            return cb.equal(r.get("priority"), priority);
        };
    }

    public static Specification<Task> hasActive(Boolean bool) {
        return (r, q, cb) -> {
            if(bool == null) return cb.conjunction();
            return cb.equal(r.get("isActive"), bool);
        };
    }
}
