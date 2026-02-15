package com.example.taskmanager.dto;

import com.example.taskmanager.entity.TaskStatus;
import java.time.LocalDateTime;

public class TaskResponse {

    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private LocalDateTime createdAt;

    // constructor
    public TaskResponse(Long id, String title, String description,
                        TaskStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.createdAt = createdAt;
    }

    // getters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public TaskStatus getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
