package com.hexagonalSpringBoot.tasks.domain.ports.in;

import com.hexagonalSpringBoot.tasks.domain.models.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task);
}
