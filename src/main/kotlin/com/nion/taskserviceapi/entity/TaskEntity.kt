package com.nion.taskserviceapi.entity

import com.nion.taskserviceapi.entity.dictionary.TaskPriority
import com.nion.taskserviceapi.entity.dictionary.TaskStatus
import com.nion.taskserviceapi.entity.dictionary.TaskType
import jakarta.persistence.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import java.util.*

@Entity
@Table(name = "tasks")
@EntityListeners(AuditingEntityListener::class)
class TaskEntity {
    @Id @GeneratedValue(strategy = GenerationType.UUID) @Column(name = "task_id")
    var id: UUID? = null

    @Column(name = "task_name")
    var name: String? = null

    @Column(name = "task_description")
    var description: String? = null

    @Enumerated(EnumType.STRING) @Column(name = "task_priority")
    var priority: TaskPriority = TaskPriority.LOW

    @Enumerated(EnumType.STRING) @Column(name = "task_status")
    var status: TaskStatus = TaskStatus.CREATED

    @Enumerated(EnumType.STRING) @Column(name = "task_type")
    var type: TaskType = TaskType.WORK

    @Column(name = "auto_complete")
    var autoComplete: Boolean = false

    @Column(name = "date_start")
    var dateStart: LocalDateTime? = null

    @Column(name = "date_end")
    var dateEnd: LocalDateTime? = null

    @CreatedDate @Column(name = "created_at")
    var createdDate: LocalDateTime? = null

    @LastModifiedDate @Column(name = "updated_at")
    var updatedDate: LocalDateTime? = null

    @ManyToOne(fetch = FetchType.EAGER) @JoinColumn(name = "user_id")
    var users: UserEntity? = null
}