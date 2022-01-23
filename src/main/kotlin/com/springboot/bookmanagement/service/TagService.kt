package com.springboot.bookmanagement.service

import com.springboot.bookmanagement.service.model.TagModel

interface TagService {

    fun createTag(tagCreateRequest: TagModel): TagModel

    fun getTagById(tagId: Long): TagModel

    fun updateTagById(tagId: Long, tagUpdateRequest: TagModel): TagModel

    fun listTags(): List<TagModel>

    fun deleteTagById(tagId: Long)
}