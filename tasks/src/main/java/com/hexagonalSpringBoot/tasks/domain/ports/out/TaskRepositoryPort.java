package com.hexagonalSpringBoot.tasks.domain.ports.out;

import com.hexagonalSpringBoot.tasks.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPort {
    Task save(Task task);
    Optional<Task> findById(Long id);
    List<Task> findAll();

    Optional<Task> update(Task task);
    boolean delete(Long id);


}
