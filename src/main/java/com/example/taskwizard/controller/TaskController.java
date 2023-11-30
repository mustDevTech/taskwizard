package com.example.taskwizard.controller;

import com.example.taskwizard.entity.TaskEntity;
import com.example.taskwizard.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Optional;

/**
 * Controller for {@link TaskEntity}
 */
@Controller
@RequiredArgsConstructor
public class TaskController {
    private final TaskService service;

    @GetMapping("/")
    public String tasksPage(Map<String, Object> model) {
        Iterable<TaskEntity> tasks = service.getAllTasks();
        model.put("tasks", tasks);
        return "index";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String task_description, Map<String, Object> model) {
        TaskEntity task = new TaskEntity(task_description);
        service.saveTask(task);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long taskId) {
        service.deleteTaskById(taskId);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String updateTaskStatus(@PathVariable("id") Long taskId, @RequestParam Boolean completed) {
        Optional<TaskEntity> task = service.findTaskById(taskId);
        if (task.isPresent()) {
            TaskEntity updatedTask = task.get();
            updatedTask.setCompleted(completed);
            service.saveTask(updatedTask);
        }
        return "redirect:/";
    }
}