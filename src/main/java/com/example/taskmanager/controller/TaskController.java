package com.example.taskmanager.controller;

import com.example.taskmanager.dto.TaskRequest;
import com.example.taskmanager.dto.TaskResponse;
import com.example.taskmanager.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.taskmanager.entity.Task;


@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<String> createTask(@Valid @RequestBody TaskRequest request) {
        taskService.createTask(request);
        return ResponseEntity.ok("Task created successfully");
    }

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getMyTasks() {
        return ResponseEntity.ok(taskService.getMyTasks());
    }
}
