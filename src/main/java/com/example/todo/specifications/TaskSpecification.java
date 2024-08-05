package com.example.todo.specifications;

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
}
