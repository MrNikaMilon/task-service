package com.nion.taskserviceapi.entity

import com.nion.taskserviceapi.entity.dictionary.TaskStatus
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "tasks")
class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "task_id")
    var id: UUID? = null
    @Column(name = "task_name")
    var name: String? = null
    @Column(name = "task_description")
    var description: String? = null
    @Enumerated(EnumType.STRING)
    @Column(name = "task_status")
    var status: TaskStatus = TaskStatus.CREATED
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    var users: UserEntity? = null
}