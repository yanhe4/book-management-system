package com.springboot.bookmanagement.service

import com.springboot.bookmanagement.service.model.BookModel

interface BookService {

    fun createBook(bookModel: BookModel): BookModel

    fun getBookById(bookId: Long): BookModel

    fun updateBookById(bookId: Long, bookModel: BookModel): BookModel

    fun listBooks(): List<BookModel>

    fun deleteBookById(bookId: Long)

    fun addTagToBook(bookId: Long, tagId: Long): BookModel

    fun removeTagFromBook(bookId: Long, tagId: Long): BookModel
}