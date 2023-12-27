package com.example.taskwizard.service;

import com.example.taskwizard.dto.TaskDto;
import com.example.taskwizard.entity.TaskEntity;
import com.example.taskwizard.mapper.TaskMapper;
import com.example.taskwizard.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Represents {@link TaskService}
 */
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskMapper mapper;
    private final TaskRepository repository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveTask(TaskDto taskDto) {
        final TaskEntity entity = mapper.toEntity(taskDto);
        if (entity.getDescription() != null && !entity.getDescription().isEmpty()) {
            repository.save(entity);
        } else {
            throw new IllegalArgumentException("Description can't be empty");
        }
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public List<TaskDto> getAllTasks() {
        final List<TaskEntity> taskEntities = (List<TaskEntity>) repository.findAll();
        return taskEntities.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteTaskById(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        }
    }

    @Override
    @Transactional(readOnly = true, rollbackFor = Exception.class)
    public Optional<TaskDto> findTaskById(Long id) {
        Optional<TaskEntity> taskEntity = repository.findById(id);
        return taskEntity.map(mapper::toDto);
    }
}