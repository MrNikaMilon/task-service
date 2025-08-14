package com.nion.taskserviceapi.controller.dto.request

import com.nion.taskserviceapi.entity.dictionary.TaskPriority
import com.nion.taskserviceapi.entity.dictionary.TaskStatus
import com.nion.taskserviceapi.entity.dictionary.TaskType
import java.time.LocalDateTime

data class TaskCreateRequest(
    var name: String,
    var description: String,
    var dateStart: LocalDateTime,
    var dateEnd: LocalDateTime,
    var priority: TaskPriority,
    var status: TaskStatus,
    var type: TaskType,
    var autoComplete: Boolean
) { }