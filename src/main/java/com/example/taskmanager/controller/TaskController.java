package com.example.taskmanager.controller;

import com.example.taskmanager.dto.TaskRequest;
import com.example.taskmanager.dto.TaskResponse;
import com.example.taskmanager.dto.UpdateTaskRequest;
import com.example.taskmanager.service.TaskService;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // CREATE TASK
    @PostMapping
    public ResponseEntity<String> createTask(@Valid @RequestBody TaskRequest request) {
        taskService.createTask(request);
        return ResponseEntity.ok("Task created successfully");
    }

    // GET MY TASKS
    @GetMapping
    public ResponseEntity<List<TaskResponse>> getMyTasks() {
        return ResponseEntity.ok(taskService.getMyTasks());
    }

    // UPDATE TASK
    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody UpdateTaskRequest request) {

        return ResponseEntity.ok(taskService.updateTask(id, request));
    }

    // DELETE TASK
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {

        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully");
    }
}
