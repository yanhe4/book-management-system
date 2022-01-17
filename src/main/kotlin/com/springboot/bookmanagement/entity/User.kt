package com.springboot.bookmanagement.entity

import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

data class User(
//    User: id, userName, password, role

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @Column(name = "user_name")
    var userName: String,
    var password: String,
    var role: Role
)

enum class Role {
    USER, ADMIN
}
