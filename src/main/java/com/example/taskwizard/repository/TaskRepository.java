package com.example.taskwizard.repository;

import com.example.taskwizard.entity.TaskEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for {@link TaskEntity}
 */
@Repository
public interface TaskRepository extends CrudRepository<TaskEntity, Long> {
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE tasks SET status = ?2 WHERE id = ?1")
    void updateTaskStatus(Long id, Boolean completed);
}