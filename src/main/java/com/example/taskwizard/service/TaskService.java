package com.example.taskwizard.service;

import com.example.taskwizard.dto.TaskDto;
import com.example.taskwizard.entity.TaskEntity;

import java.util.List;
import java.util.Optional;

/**
 * Service for {@link TaskEntity}
 */
public interface TaskService {
    void saveTask(TaskDto taskDto);
    List<TaskDto> getAllTasks();
    void deleteTaskById(Long id);
    Optional<TaskDto> findTaskById(Long id);
}