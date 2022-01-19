package com.springboot.bookmanagement.service

import com.springboot.bookmanagement.dto.BookDto

interface BookService {

    fun createBook(bookCreateRequest: BookDto): BookDto
}