package com.springboot.bookmanagement.controller.dto

import com.springboot.bookmanagement.repository.entity.Status
import com.springboot.bookmanagement.service.model.BookModel

data class BookDto (
    var id: Long,
    var title: String,
    var author: String,
    var status: Status,
    var tags: List<TagDto>
)

fun BookDto.toModel() = BookModel(
    id = id,
    title = title,
    author = author,
    status = status,
    tagModels = tags.map { tagDto -> tagDto.toModel() }
)

fun BookModel.fromModel() = BookDto(
    id = id,
    title = title,
    author = author,
    status = status,
    tags = tagModels.map { tagModel -> tagModel.fromModel() }
)
