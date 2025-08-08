package com.nion.taskserviceapi.entity

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.util.UUID

@Entity
@Table(name = "users")
class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    var id: UUID? = null
    @Column(name = "user_name")
    var name: String? = null
    @Column(name = "user_email")
    var email: String? = null
    @Column(name = "user_password")
    var password: String? = null
    @Column(name = "user_phone")
    var phone: String? = null
    @OneToMany(mappedBy = "users", cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    var tasks: MutableList<TaskEntity> = mutableListOf()
}