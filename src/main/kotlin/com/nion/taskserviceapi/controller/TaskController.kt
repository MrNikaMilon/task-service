package com.nion.taskserviceapi.controller

import com.nion.taskserviceapi.controller.dto.request.TaskCreateRequest
import com.nion.taskserviceapi.controller.dto.request.TaskDeleteRequest
import com.nion.taskserviceapi.controller.dto.request.TaskUpdateRequest
import com.nion.taskserviceapi.controller.dto.response.TasksResponse
import com.nion.taskserviceapi.service.TaskService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

private val log = LoggerFactory.getLogger(TaskController::class.java)

@RestController
@RequestMapping(value = ["/api/v1"])
class TaskController(
    val taskService: TaskService
) {
    @Operation(
        summary = "Creates a new task",
        description = "Creates a new task by user",
        responses = [
            ApiResponse(
                responseCode = "201",
                description = "Task created",
                content = [
                    Content(
                        mediaType = "application/json",
                        schema = Schema(implementation = TaskCreateRequest::class)
                    )
                ]
            )
        ]
    )
    @PostMapping(value = ["/task/create"])
    fun createTask(
        @io.swagger.v3.oas.annotations.parameters.RequestBody(
                description = "data for creating task",
                required = true,
                content = [Content(
                    mediaType = "application/json",
                    schema = Schema(implementation = TasksResponse::class)
                )]
        )
        @RequestBody task: TaskCreateRequest
    ): ResponseEntity<TasksResponse> {
        log.debug("create task with name {}", task.name)
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(taskService.createTask(task))
    }

    @PatchMapping(value = ["tasks/{task_id}"])
    fun updateTask(@RequestBody task: TaskUpdateRequest,
                   @PathVariable(name = "task_id") taskId: UUID): ResponseEntity<TasksResponse> {
        return ResponseEntity
            .status(HttpStatus.NOT_IMPLEMENTED)
            .body( TasksResponse())
    }

    @DeleteMapping(value = ["tasks/{task_id}"])
    fun deleteTask(@RequestBody task: TaskDeleteRequest,
                   @PathVariable(name = "task_id") taskId: UUID): ResponseEntity<HttpStatus> {
        return ResponseEntity.ok(HttpStatus.NO_CONTENT)
    }

    @PatchMapping(value = ["tasks/decline/{task_id}"])
    fun declineTask(@RequestBody task: TaskUpdateRequest,
                    @PathVariable(name = "task_id") taskId: UUID): ResponseEntity<TasksResponse> {
        return ResponseEntity.ok(TasksResponse())
    }
}