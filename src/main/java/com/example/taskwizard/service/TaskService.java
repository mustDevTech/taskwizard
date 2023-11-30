package com.example.taskwizard.service;

import com.example.taskwizard.entity.TaskEntity;

import java.util.List;
import java.util.Optional;

/**
 * Service for {@link TaskEntity}
 */
public interface TaskService {
    void saveTask(TaskEntity task);
    List<TaskEntity> getAllTasks();
    void deleteTaskById(Long id);
    Optional<TaskEntity> findTaskById(Long id);
}