package com.hexagonalSpringBoot.tasks.application.usecases;

import com.hexagonalSpringBoot.tasks.domain.models.Task;
import com.hexagonalSpringBoot.tasks.domain.ports.in.CreateTaskUseCase;
import com.hexagonalSpringBoot.tasks.domain.ports.out.TaskRepositoryPort;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }
}
