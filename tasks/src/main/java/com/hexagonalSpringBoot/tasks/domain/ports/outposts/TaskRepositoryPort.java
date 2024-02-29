package com.hexagonalSpringBoot.tasks.domain.ports.outposts;

import com.hexagonalSpringBoot.tasks.domain.models.Task;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPort {
    Task save(Task task);
    Optional<Task> findById(Long id);
    List<Task> findAll();

    Optional<Task> update(Task task);
    boolean delete(Long id);


}
