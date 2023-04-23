package com.example.taskwizard.service;

import com.example.taskwizard.entity.TaskEntity;
import com.example.taskwizard.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService
{
    @Autowired
    private TaskRepository taskRepository;

    public void saveTask(TaskEntity task)
    {
        if (task.getDescription() != null && !task.getDescription().isEmpty())
        {
            taskRepository.save(task);
        }
    }

    public List<TaskEntity> getAllTasks()
    {
        return (List<TaskEntity>) taskRepository.findAll();
    }

    public void deleteTaskById(Long id)
    {
        if (taskRepository.existsById(id))
        {
            taskRepository.deleteById(id);
        }
    }

    public Optional<TaskEntity> findTaskById(Long id)
    {
        return taskRepository.findById(id);
    }
}