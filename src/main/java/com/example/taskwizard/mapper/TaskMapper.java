package com.example.taskwizard.mapper;

import com.example.taskwizard.dto.TaskDto;
import com.example.taskwizard.entity.TaskEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

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
    @Mapping(source = "entity.description", target = "description")
    TaskDto toDto(TaskEntity entity);

    /**
     * Maps {@link TaskDto} to {@link TaskEntity}
     * @param dto {@link TaskDto}
     * @return {@link TaskEntity}
     */
    @Mapping(source = "dto.description", target = "description")
    TaskEntity toEntity(TaskDto dto);
}