package com.springboot.bookmanagement.service.model

import com.springboot.bookmanagement.repository.entity.Tag

data class TagModel(
    var id: Long,
    var tagName: String,
    var description: String,
)

fun TagModel.toEntity() = Tag(
    id = id,
    tagName = tagName,
    description = description
)

fun Tag.fromEntity() = TagModel(
    id = id,
    tagName = tagName,
    description = description
)