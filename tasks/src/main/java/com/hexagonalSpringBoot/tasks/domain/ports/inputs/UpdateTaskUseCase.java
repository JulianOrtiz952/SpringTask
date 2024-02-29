package com.hexagonalSpringBoot.tasks.domain.ports.inputs;

import com.hexagonalSpringBoot.tasks.domain.models.Task;

import java.util.Optional;

public interface UpdateTaskUseCase {
    Optional<Task> updateTask(Long id, Task task);
}
