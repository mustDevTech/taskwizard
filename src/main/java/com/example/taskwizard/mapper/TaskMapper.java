package com.example.taskwizard.mapper;

import com.example.taskwizard.dto.TaskDto;
import com.example.taskwizard.entity.TaskEntity;
import org.mapstruct.Mapper;

/**
 * Mapper for {@link TaskEntity}
 */
@Mapper(componentModel = "spring")
public interface TaskMapper {
    /**
     * Maps {@link TaskEntity} to {@link TaskDto}
     * @param entity {@link TaskEntity}
     * @return {@link TaskDto}
     */
    TaskDto toDto(TaskEntity entity);

    /**
     * Maps {@link TaskDto} to {@link TaskEntity}
     * @param dto {@link TaskDto}
     * @return {@link TaskEntity}
     */
    TaskEntity toEntity(TaskDto dto);
}