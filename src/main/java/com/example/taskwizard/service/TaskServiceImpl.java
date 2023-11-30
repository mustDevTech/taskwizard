package com.example.taskwizard.service;

import com.example.taskwizard.entity.TaskEntity;
import com.example.taskwizard.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Represents {@link TaskService}
 */
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository repository;

    @Override
    public void saveTask(TaskEntity task) {
        if (task.getDescription() != null && !task.getDescription().isEmpty()) {
            repository.save(task);
        }
    }

    @Override
    public List<TaskEntity> getAllTasks() {
        return (List<TaskEntity>) repository.findAll();
    }

    @Override
    public void deleteTaskById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    @Override
    public Optional<TaskEntity> findTaskById(Long id) {
        return repository.findById(id);
    }
}