package com.nion.taskserviceapi.mapper

import com.nion.taskserviceapi.controller.dto.request.TaskCreateRequest
import com.nion.taskserviceapi.controller.dto.response.TasksResponse
import com.nion.taskserviceapi.entity.TaskEntity
import org.mapstruct.Mapper
import org.mapstruct.Mapping

@Mapper(componentModel = "spring")
interface TaskMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "users", ignore = true)
    fun toTaskEntity(task: TaskCreateRequest): TaskEntity

    fun toTaskResponse(task: TaskEntity): TasksResponse
}