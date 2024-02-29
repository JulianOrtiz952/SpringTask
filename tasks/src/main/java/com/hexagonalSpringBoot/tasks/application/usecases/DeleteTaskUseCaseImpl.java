package com.hexagonalSpringBoot.tasks.application.usecases;

import com.hexagonalSpringBoot.tasks.domain.ports.in.DeleteTaskUseCase;
import com.hexagonalSpringBoot.tasks.domain.ports.out.TaskRepositoryPort;

public class DeleteTaskUseCaseImpl implements DeleteTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public DeleteTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public boolean deleteTask(Long id) {
        return taskRepositoryPort.delete(id);
    }
}
