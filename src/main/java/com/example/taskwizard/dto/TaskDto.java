package com.example.taskwizard.dto;

import com.example.taskwizard.entity.TaskEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

/**
 * Dto of entity {@link TaskEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskDto implements Serializable {
    Long id;
    String description;
    Boolean isCompleted;

    public TaskDto(String description) {
        this.description = description;
        this.isCompleted = false;
    }
}