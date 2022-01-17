package com.springboot.bookmanagement.service.impl

import com.springboot.bookmanagement.entity.Book
import org.springframework.stereotype.Service

@Service
class BookService {
    fun getBookById(bookId: Long): Book {
        TODO("Not yet implemented")
    }

    fun createBook(bookCreateRequest: Book): Book {
        TODO("Not yet implemented")
    }

    fun updateBookById(bookId: Long, bookUpdateRequest: Book): Book {
        TODO("Not yet implemented")
    }

    fun deleteBookById(bookId: Long) {
        TODO("Not yet implemented")
    }

    fun addTagToBook(bookId: Long, tagId: Long): Book {
        TODO("Not yet implemented")
    }

    fun removeTagFromBook(bookId: Long, tagId: Long): Book {
        TODO("Not yet implemented")
    }
}