package com.springboot.bookmanagement.dto

import com.springboot.bookmanagement.entity.Book
import com.springboot.bookmanagement.entity.Status
import com.springboot.bookmanagement.entity.Tag
import com.springboot.bookmanagement.service.impl.BookServiceImpl

data class BookDto(

    var id: Long,
    var title: String,
    var author: String,
    var status: Status,
    var tags: List<Tag>
)

fun BookDto.fromBookDtoToBook() = Book(
    id = id,
    title = title,
    author = author,
    status = status,
    tags = tags
)