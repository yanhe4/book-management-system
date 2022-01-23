package com.springboot.bookmanagement.repository

import com.springboot.bookmanagement.repository.entity.Tag
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TagRepository : JpaRepository<Tag, Long> {
}