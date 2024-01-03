package com.example.taskwizard.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

/**
 * Entity class that represents Task.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tasks")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Description cannot be empty!")
    @Column(name = "description")
    private String description;

    @NotNull(message = "Status cannot be null!")
    @Column(name = "status")
    private Boolean isCompleted;

    public TaskEntity(String description) {
        this.description = description;
        this.isCompleted = false;
    }


    //region toString, equals, hashCode
    @Override
    public String toString() {
        return "TaskEntity{" + "id=" + id + ", description='" + description + '\'' + ", isCompleted=" + isCompleted + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TaskEntity that = (TaskEntity) o;
        return isCompleted == that.isCompleted && Objects.equals(id, that.id) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, isCompleted);
    }
    //endregion
}