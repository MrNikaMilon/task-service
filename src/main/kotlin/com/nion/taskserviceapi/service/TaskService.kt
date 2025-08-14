package com.nion.taskserviceapi.service

import com.nion.taskserviceapi.controller.dto.request.TaskCreateRequest
import com.nion.taskserviceapi.controller.dto.response.TasksResponse
import com.nion.taskserviceapi.mapper.TaskMapper
import com.nion.taskserviceapi.repository.TaskRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

private val log = LoggerFactory.getLogger(TaskService::class.java)

@Service
class TaskService(
    val taskRepository: TaskRepository,
    val taskMapper: TaskMapper
) {
    fun createTask(task: TaskCreateRequest): TasksResponse {
        var entity = taskMapper.toTaskEntity(task)
        entity = taskRepository.save(entity)
        log.debug("successful saving task {}", entity)
        return taskMapper.toTaskResponse(entity)
    }
}