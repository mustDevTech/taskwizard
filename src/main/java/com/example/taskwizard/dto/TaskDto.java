package com.example.taskwizard.dto;

import com.example.taskwizard.entity.TaskEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Objects;

/**
 * Dto of entity {@link TaskEntity}
 */
@Getter
@Setter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskDto implements Serializable {
    Long id;
    String description;
    Boolean isCompleted;

    public TaskDto(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    //region toString, equals, hashCode
    @Override
    public String toString() {
        return "TaskDto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", isCompleted=" + isCompleted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TaskDto taskDto = (TaskDto) o;
        return Objects.equals(id, taskDto.id) && Objects.equals(description, taskDto.description) && Objects.equals(isCompleted, taskDto.isCompleted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, isCompleted);
    }
    //endregion
}