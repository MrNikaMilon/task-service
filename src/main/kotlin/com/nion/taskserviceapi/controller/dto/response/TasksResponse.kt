package com.nion.taskserviceapi.controller.dto.response

import com.nion.taskserviceapi.entity.dictionary.TaskPriority
import com.nion.taskserviceapi.entity.dictionary.TaskStatus
import com.nion.taskserviceapi.entity.dictionary.TaskType
import java.time.LocalDateTime

data class TasksResponse(
    var name: String? = null,
    var description: String? = null,
    var dateStart: LocalDateTime? = null,
    var dateEnd: LocalDateTime? = null,
    var priority: TaskPriority? = null,
    var status: TaskStatus? = null,
    var type: TaskType? = null,
    var autoComplete: Boolean? = null,
) { }