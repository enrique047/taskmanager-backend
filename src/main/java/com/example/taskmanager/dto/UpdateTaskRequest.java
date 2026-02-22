package com.example.taskmanager.dto;

import jakarta.validation.constraints.NotBlank;

public class UpdateTaskRequest {

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Status is required")
    private String status;

    private String description;


    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getStatus() { return status; }
}
