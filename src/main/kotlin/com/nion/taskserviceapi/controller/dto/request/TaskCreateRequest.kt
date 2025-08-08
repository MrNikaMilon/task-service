package com.nion.taskserviceapi.controller.dto.request

import com.nion.taskserviceapi.entity.dictionary.TaskPriority
import java.time.LocalDateTime

data class TaskCreateRequest(
    var name: String,
    var description: String,
    var dateStart: LocalDateTime,
    var dateEnd: LocalDateTime,
    var priority: TaskPriority,
) { }