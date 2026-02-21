package com.example.taskmanager.repository;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.entity.TaskStatus;
import com.example.taskmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.*;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Page<Task> findByUser(User user, Pageable pageable);
    Optional<Task> findByIdAndUserId(Long taskId, Long userId);
    List<Task> findAllByUserId(Long userId);
    Page<Task> findByUserAndStatus(User user, TaskStatus status, Pageable pageable);
    Page<Task> findByUserAndTitleContainingIgnoreCase(User user, String title, Pageable pageable);
    Page<Task> findByUserAndStatusAndTitleContainingIgnoreCase(User user, TaskStatus status, String title, Pageable pageable);
}
