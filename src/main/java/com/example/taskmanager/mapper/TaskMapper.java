package com.example.taskmanager.mapper;

import com.example.taskmanager.dto.TaskResponse;
import com.example.taskmanager.entity.Task;

public class TaskMapper {

    public static TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getStatus(),
                task.getCreatedAt()
        );
    }
}
