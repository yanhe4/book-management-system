package com.springboot.bookmanagement.service.model

import com.springboot.bookmanagement.repository.entity.Book
import com.springboot.bookmanagement.repository.entity.Status
import com.springboot.bookmanagement.repository.entity.Tag

data class BookModel(

    var id: Long,
    var title: String,
    var author: String,
    var status: Status,
    var tagModels: List<TagModel>
)

fun BookModel.toEntity() = Book(
    id = id,
    title = title,
    author = author,
    status = status,
    tags = tagModels.distinctBy { tagModel -> tagModel.tagName }
        .map { tagModel -> tagModel.toEntity() } as MutableList<Tag>
)

fun Book.fromEntity() = BookModel(
    id = id,
    title = title,
    author = author,
    status = status,
    tagModels = tags.map { tagEntity -> tagEntity.fromEntity() }
)