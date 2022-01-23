package com.springboot.bookmanagement.controller.dto

import com.springboot.bookmanagement.service.model.TagModel

data class TagDto(
    var id: Long,
    var tagName: String,
    var description: String,
)

fun TagDto.toModel() = TagModel(
    id = id,
    tagName = tagName,
    description = description
)

fun TagModel.fromModel() = TagDto(
    id = id,
    tagName = tagName,
    description = description
)
