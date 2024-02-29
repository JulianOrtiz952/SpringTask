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
        return ResponseEntity.ok(taskService.createTask(task));
    }

    @GetMapping("/task/{id}")
    public ResponseEntity<?> findTaskById(@PathVariable Long id){
        return ResponseEntity.ok(taskService.getTask(id));
    }

    @GetMapping("/taskgetall")
    public ResponseEntity<?> findAllTask(){
        return ResponseEntity.ok(taskService.getAllTask());
    }

    @PutMapping("/taskupdate/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Task task){
        return ResponseEntity.ok(taskService.updateTask(id, task));
    }

    @DeleteMapping("/taskdeletebyid/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        if(taskService.deleteTask(id)) return ResponseEntity.ok("task has been deleted");
        return ResponseEntity.badRequest().body("task has not been deleted");
    }

}
