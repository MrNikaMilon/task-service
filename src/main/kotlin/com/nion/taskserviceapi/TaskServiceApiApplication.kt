package com.nion.taskserviceapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TaskServiceApiApplication

fun main(args: Array<String>) {
    runApplication<TaskServiceApiApplication>(*args)
}
