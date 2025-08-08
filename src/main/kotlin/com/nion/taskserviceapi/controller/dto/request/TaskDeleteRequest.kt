package com.nion.taskserviceapi.controller.dto.request

import com.nion.taskserviceapi.entity.dictionary.TaskStatus

data class TaskDeleteRequest(
    var taskId: String? = null,
    var taskStatus: TaskStatus,
    var isSoft: Boolean = false) { }