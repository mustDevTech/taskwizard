package com.example.taskwizard.controller;

import com.example.taskwizard.entity.TaskEntity;
import com.example.taskwizard.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
public class TaskController
{
    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String tasksPage(Map<String, Object> model)
    {
        Iterable<TaskEntity> tasks = taskService.getAllTasks();
        model.put("tasks", tasks);
        return "index";
    }

    @PostMapping("/add")
    public String addTask(@RequestParam String task_description, Map<String, Object> model)
    {
        TaskEntity task = new TaskEntity(task_description);
        taskService.saveTask(task);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long taskId)
    {
        taskService.deleteTaskById(taskId);
        return "redirect:/";
    }

    @PostMapping("/update/{id}")
    public String updateTaskStatus(@PathVariable("id") Long taskId, @RequestParam Boolean completed)
    {
        Optional<TaskEntity> task = taskService.findTaskById(taskId);
        if (task.isPresent())
        {
            TaskEntity updatedTask = task.get();
            updatedTask.setCompleted(completed);
            taskService.saveTask(updatedTask);
        }
        return "redirect:/";
    }
}