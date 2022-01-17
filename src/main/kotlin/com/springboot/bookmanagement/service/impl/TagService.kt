package com.springboot.bookmanagement.service.impl

import com.springboot.bookmanagement.entity.Tag
import org.springframework.stereotype.Service

@Service
class TagService {
    fun getTagById(tagId: Long): Tag {
        TODO("Not yet implemented")
    }

    fun createTag(tagCreateRequest: Tag): Tag {
        TODO("Not yet implemented")
    }

    fun updateTagById(tagId: Long, tagUpdateRequest: Tag): Tag {
        TODO("Not yet implemented")
    }

    fun deleteTagById(tagId: Long) {
        TODO("Not yet implemented")
    }

    fun addBookUnderTag(tagId: Long, bookId: Long): Tag {
        TODO("Not yet implemented")
    }

    fun removeBookUnderTag(tagId: Long, bookId: Long): Tag {
        TODO("Not yet implemented")
    }

}
