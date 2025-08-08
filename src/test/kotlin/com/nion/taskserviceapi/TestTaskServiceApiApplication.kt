package com.nion.taskserviceapi

import org.springframework.boot.fromApplication
import org.springframework.boot.with


fun main(args: Array<String>) {
    fromApplication<TaskServiceApiApplication>().with(TestcontainersConfiguration::class).run(*args)
}
