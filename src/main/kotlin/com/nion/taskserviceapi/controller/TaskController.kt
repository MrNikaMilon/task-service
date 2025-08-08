package com.nion.taskserviceapi.controller

import com.nion.taskserviceapi.controller.dto.request.TaskCreateRequest
import com.nion.taskserviceapi.controller.dto.request.TaskDeleteRequest
import com.nion.taskserviceapi.controller.dto.request.TaskUpdateRequest
import com.nion.taskserviceapi.controller.dto.response.TasksResponse
import com.nion.taskserviceapi.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping(value = ["/api/v1"])
class TaskController(
    val taskService: TaskService,
) {
    @PostMapping(value = ["/task/create"])
    fun createTask(@RequestBody task: TaskCreateRequest): ResponseEntity<TasksResponse> {
        return ResponseEntity.ok(TasksResponse())
    }

    @PatchMapping(value = ["tasks/{task_id}"])
    fun updateTask(@RequestBody task: TaskUpdateRequest,
                   @PathVariable(name = "task_id") taskId: UUID): ResponseEntity<TasksResponse> {
        return ResponseEntity.ok(TasksResponse())
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