package com.springboot.bookmanagement.service.impl

import com.springboot.bookmanagement.dto.BookDto
import com.springboot.bookmanagement.dto.fromBookDtoToBook
import com.springboot.bookmanagement.entity.Book
import com.springboot.bookmanagement.entity.toBookDto
import com.springboot.bookmanagement.repository.BookRepository
import com.springboot.bookmanagement.service.BookService
import org.springframework.stereotype.Service

@Service
class BookServiceImpl(private val bookRepository: BookRepository): BookService {
    fun getBookById(bookId: Long): Book {
        TODO("Not yet implemented")
    }

    override fun createBook(bookCreateRequest: BookDto): BookDto {

        // convert DTO to entity
        val book: Book = bookCreateRequest.fromBookDtoToBook()

        val newBook: Book = bookRepository.save(book)

        // convert entity to DTO
        return newBook.toBookDto()
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