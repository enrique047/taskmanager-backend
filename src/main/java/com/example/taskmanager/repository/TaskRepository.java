package com.example.taskmanager.repository;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByUser(User user);
    Optional<Task> findByIdAndUserId(Long taskId, Long userId);
    List<Task> findAllByUserId(Long userId);

}
