package com.example.taskwizard.service;

import com.example.taskwizard.dto.TaskDto;
import com.example.taskwizard.entity.TaskEntity;

import java.util.List;

/**
 * Service for {@link TaskEntity}
 */
public interface TaskService {
    void saveTask(TaskDto taskDto);
    List<TaskDto> getAllTasks();
    void deleteTaskById(Long id);
    TaskDto findTaskById(Long id);
    void updateTaskStatusById(Long taskId, Boolean completed);
}