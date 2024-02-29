package com.hexagonalSpringBoot.tasks.infrastructure.controllers;

import com.hexagonalSpringBoot.tasks.application.services.TaskService;
import com.hexagonalSpringBoot.tasks.domain.models.Task;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/task")
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.ok(createdTask);
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<?> findTaskById(@PathVariable Long id){
        Optional<Task> taskOptional = taskService.getTask(id);
        if(taskOptional.isEmpty()) return ResponseEntity.notFound().build();
        Task task = taskOptional.get();
        return ResponseEntity.ok(task);
    }

    @GetMapping("/taskgetall")
    public ResponseEntity<?> findAllTask(){
        List<Task> taskList = taskService.getAllTask();
        return ResponseEntity.ok(taskList);
    }

    @PutMapping("/taskupdate/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Task task){
        Optional<Task> taskOptional = taskService.getTask(id);
        if(taskOptional.isEmpty()) return ResponseEntity.notFound().build();
        Task taskReply = taskOptional.get();
        return ResponseEntity.ok(taskService.updateTask(id, taskReply));
    }

    @DeleteMapping("/taskdeletebyid/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(taskService.deleteTask(id)) return ResponseEntity.ok("task has been deleted");
        return ResponseEntity.badRequest().body("task has not been deleted");
    }

}
