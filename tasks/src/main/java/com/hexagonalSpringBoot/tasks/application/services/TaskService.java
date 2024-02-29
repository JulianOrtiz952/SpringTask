package com.hexagonalSpringBoot.tasks.application.services;

import com.hexagonalSpringBoot.tasks.domain.models.AdditionalTaskInfo;
import com.hexagonalSpringBoot.tasks.domain.models.Task;
import com.hexagonalSpringBoot.tasks.domain.ports.in.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class TaskService implements CreateTaskUseCase, DeleteTaskUseCase, RetrieveTaskUseCase, UpdateTaskUseCase, GetAdditionalTaskUseCase {

    private final CreateTaskUseCase createTaskUseCase;
    private final DeleteTaskUseCase deleteTaskUseCase;
    private final RetrieveTaskUseCase retrieveTaskUseCase;
    private final UpdateTaskUseCase updateTaskUseCase;
    private final GetAdditionalTaskUseCase getAdditionalTaskUseCase;

    public TaskService(CreateTaskUseCase createTaskUseCase, DeleteTaskUseCase deleteTaskUseCase, RetrieveTaskUseCase retrieveTaskUseCase, UpdateTaskUseCase updateTaskUseCase, GetAdditionalTaskUseCase getAdditionalTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
        this.deleteTaskUseCase = deleteTaskUseCase;
        this.retrieveTaskUseCase = retrieveTaskUseCase;
        this.updateTaskUseCase = updateTaskUseCase;
        this.getAdditionalTaskUseCase = getAdditionalTaskUseCase;
    }

    @Override
    public Task createTask(Task task) {
        return createTaskUseCase.createTask(task);
    }

    @Override
    public boolean deleteTask(Long id) {
        return deleteTaskUseCase.deleteTask(id);
    }

    @Override
    public AdditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return getAdditionalTaskUseCase.getAdditionalTaskInfo(id);
    }

    @Override
    public Optional<Task> getTask(Long id) {
        Optional<Task> taskOptional = retrieveTaskUseCase.getTask(id);
        if(taskOptional.isEmpty()) throw new RuntimeException("not founded");
        Task task = taskOptional.get();
        return Optional.of(task);
    }

    @Override
    public List<Task> getAllTask() {
        return retrieveTaskUseCase.getAllTask();
    }

    @Override
    public Optional<Task> updateTask(Long id, Task task) {
        Optional<Task> taskOptional = retrieveTaskUseCase.getTask(id);
        if(taskOptional.isEmpty()) throw new RuntimeException("not founded");
        Task taskReply = taskOptional.get();
        updateTaskUseCase.updateTask(id, taskReply);
        return Optional.of(taskReply);
    }
}
