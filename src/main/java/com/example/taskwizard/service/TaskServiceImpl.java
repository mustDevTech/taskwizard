package com.example.taskwizard.service;

import com.example.taskwizard.dto.TaskDto;
import com.example.taskwizard.entity.TaskEntity;
import com.example.taskwizard.mapper.TaskMapper;
import com.example.taskwizard.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Represents {@link TaskService}
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class TaskServiceImpl implements TaskService {
    private final TaskMapper mapper;
    private final TaskRepository repository;

    /**
     * Saves a task.
     * @param taskDto the TaskDto object representing the task to be saved
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveTask(TaskDto taskDto) {
        final TaskEntity entity = mapper.toEntity(taskDto);
        if (entity.getDescription() == null || entity.getDescription().isEmpty()) {
            log.log(Level.WARN, "Task description cannot be empty!");
        } else {
            repository.save(entity);
        }
    }

    /**
     * Retrieves all tasks.
     * @return a list of tasks as TaskDto objects
     */
    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<TaskDto> getAllTasks() {
        final List<TaskEntity> taskEntities = (List<TaskEntity>) repository.findAll();
        return taskEntities.stream().map(mapper::toDto).toList();
    }

    /**
     * Deletes a task by its identifier.
     * @param id the identifier of the task to be deleted
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTaskById(Long id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            log.log(Level.WARN, "Task with id: {} not found", id);
        }
    }

    /**
     * Finds a task by its identifier.
     * @param id the identifier of the task
     * @return an Optional object containing the TaskDto representing the found task, or an empty Optional if the task is not found
     */
    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public TaskDto findTaskById(Long id) {
        final Optional<TaskEntity> taskEntity = repository.findById(id);
        return taskEntity.map(mapper::toDto).orElseThrow(() -> {
            log.log(Level.WARN, "Task with id: {} not found", id);
            return null;
        });
    }

    /**
     * Updates the status of a task.
     * @param taskId    the id of the task.
     * @param completed the new status of the task.
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateTaskStatusById(Long taskId, Boolean completed) {
        repository.updateTaskStatus(taskId, completed);
    }
}