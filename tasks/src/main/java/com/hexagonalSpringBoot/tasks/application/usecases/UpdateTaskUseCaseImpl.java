package com.hexagonalSpringBoot.tasks.application.usecases;

import com.hexagonalSpringBoot.tasks.domain.models.Task;
import com.hexagonalSpringBoot.tasks.domain.ports.in.UpdateTaskUseCase;
import com.hexagonalSpringBoot.tasks.domain.ports.out.TaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskUseCaseImpl implements UpdateTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    public UpdateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> updateTask(Long id, Task task) {
        return taskRepositoryPort.update(task);
    }
}
