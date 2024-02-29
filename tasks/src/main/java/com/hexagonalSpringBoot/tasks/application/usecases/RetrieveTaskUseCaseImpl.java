package com.hexagonalSpringBoot.tasks.application.usecases;

import com.hexagonalSpringBoot.tasks.domain.models.Task;
import com.hexagonalSpringBoot.tasks.domain.ports.in.RetrieveTaskUseCase;
import com.hexagonalSpringBoot.tasks.domain.ports.out.TaskRepositoryPort;

import java.util.List;
import java.util.Optional;

public class RetrieveTaskUseCaseImpl implements RetrieveTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public RetrieveTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> getTask(Long id) {
        return taskRepositoryPort.findById(id);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepositoryPort.findAll();
    }
}
