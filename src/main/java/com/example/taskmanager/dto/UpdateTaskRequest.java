package com.example.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;

public class UpdateTaskRequest {

    @NotBlank
    private String title;

    private String description;

    private String status;

    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
}
