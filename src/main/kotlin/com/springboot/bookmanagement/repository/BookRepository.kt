package com.springboot.bookmanagement.repository

import com.springboot.bookmanagement.repository.entity.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<Book, Long> {
}