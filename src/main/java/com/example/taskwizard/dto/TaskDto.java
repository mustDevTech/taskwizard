package com.example.taskwizard.dto;

import com.example.taskwizard.entity.TaskEntity;
import java.io.Serializable;

/**
 * Dto record of entity {@link TaskEntity}
 */
public record TaskDto(Long id, String description, Boolean isCompleted) implements Serializable {
    public TaskDto(String description) {
        this(null, description, false);
    }
}