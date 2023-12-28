package com.example.taskwizard.controller;

import com.example.taskwizard.dto.TaskDto;
import com.example.taskwizard.entity.TaskEntity;
import com.example.taskwizard.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * Controller for {@link TaskEntity}
 */
@Controller
@Log4j2
@RequiredArgsConstructor
public class TaskController {
    private final TaskService service;

    /**
     * Represents tasks page and showing all tasks to user.
     * @param model the model to be passed to the view.
     * @return tasks page.
     */
    @GetMapping("/")
    public String tasksPage(Map<String, Object> model) {
        final List<TaskDto> tasks = service.getAllTasks();
        model.put("tasks", tasks);
        return "index";
    }

    /**
     * Adds new task to html page and saves it to database.
     * @param task_description the description of task.
     * @param model            the model to be passed to the view.
     * @return redirect to tasks page and refreshes it.
     */
    @PostMapping("/add")
    public String addTask(@RequestParam String task_description, Map<String, Object> model) {
        final TaskDto taskDto = new TaskDto(task_description);
        service.saveTask(taskDto);
        log.log(Level.INFO, "Saved task description: {}", taskDto.getDescription());
        return "redirect:/";
    }


    /**
     * Deletes task from database by its id.
     * @param taskId the id of the task.
     * @return redirect to tasks page and refreshes it.
     */
    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long taskId) {
        service.deleteTaskById(taskId);
        log.log(Level.INFO, "Deleted task with id: {}", taskId);
        return "redirect:/";
    }

    /**
     * Updates task status in database by its id.
     * @param taskId    the id of the task.
     * @param completed the status of the task. 1 - completed, 0 - not completed.
     * @return redirect to tasks page and refreshes it.s
     */
    @PostMapping("/update/{id}")
    public String updateTaskStatus(@PathVariable("id") Long taskId, @RequestParam Boolean completed) {
        final Optional<TaskDto> task = service.findTaskById(taskId);
        if (task.isPresent()) {
            final TaskDto updatedTask = task.get();
            updatedTask.setIsCompleted(completed);
            service.saveTask(updatedTask);
            log.log(Level.INFO, "Updated taskID: {}, completed: {}", updatedTask.getId(), updatedTask.getIsCompleted());
        } else {
            log.log(Level.WARN, "Task with id: {} not found", taskId);
        }
        return "redirect:/";
    }
}