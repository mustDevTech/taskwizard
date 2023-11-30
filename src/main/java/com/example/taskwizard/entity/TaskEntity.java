package com.example.taskwizard.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;


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

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private boolean isCompleted;

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