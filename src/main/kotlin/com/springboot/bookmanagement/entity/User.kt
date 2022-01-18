package com.springboot.bookmanagement.entity

import javax.persistence.*

@Entity
@Table(name = "usr")
data class User(
//    User: id, userName, password, role

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @Column(name = "user_name")
    var userName: String,
    var password: String,
    @Enumerated(EnumType.STRING)
    var role: Role
)

enum class Role {
    USER, ADMIN
}
