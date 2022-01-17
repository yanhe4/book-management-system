package com.springboot.bookmanagement.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Tag(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?
)