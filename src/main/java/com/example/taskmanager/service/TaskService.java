package com.example.taskmanager.service;

import com.example.taskmanager.dto.TaskRequest;
import com.example.taskmanager.dto.TaskResponse;
import com.example.taskmanager.dto.UpdateTaskRequest;
import com.example.taskmanager.entity.Task;
import com.example.taskmanager.entity.TaskStatus;
import com.example.taskmanager.entity.User;
import com.example.taskmanager.mapper.TaskMapper;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.repository.UserRepository;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    // ================= CREATE =================
    public void createTask(TaskRequest request) {

        User user = getCurrentUser();

        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setUser(user);

        taskRepository.save(task);
    }

    // ================= READ =================
    public List<TaskResponse> getMyTasks() {

        User user = getCurrentUser();

        return taskRepository.findByUser(user)
                .stream()
                .map(TaskMapper::toResponse)
                .toList();
    }

    // ================= UPDATE =================
    public TaskResponse updateTask(Long taskId, UpdateTaskRequest request) {

        User user = getCurrentUser();

        Task task = taskRepository.findByIdAndUserId(taskId, user.getId())
                .orElseThrow(() -> new RuntimeException("Task not found or not yours"));

        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setStatus(TaskStatus.valueOf(request.getStatus()));

        taskRepository.save(task);

        return TaskMapper.toResponse(task);
    }

    // ================= DELETE =================
    public void deleteTask(Long taskId) {

        User user = getCurrentUser();

        Task task = taskRepository.findByIdAndUserId(taskId, user.getId())
                .orElseThrow(() -> new RuntimeException("Task not found or not yours"));

        taskRepository.delete(task);
    }

    // ================= HELPER =================
    private User getCurrentUser() {

        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String email = userDetails.getUsername();

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
