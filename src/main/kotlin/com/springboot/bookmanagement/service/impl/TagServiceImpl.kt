package com.springboot.bookmanagement.service.impl

import com.springboot.bookmanagement.repository.TagRepository
import com.springboot.bookmanagement.repository.entity.Tag
import com.springboot.bookmanagement.service.TagService
import com.springboot.bookmanagement.service.model.TagModel
import com.springboot.bookmanagement.service.model.fromEntity
import com.springboot.bookmanagement.service.model.toEntity
import org.springframework.stereotype.Service

@Service
class TagServiceImpl(private val tagRepository: TagRepository) : TagService {
    override fun getTagById(tagId: Long): TagModel {
        val tag: Tag = tagRepository.getById(tagId)
        return tag.fromEntity()
    }

    override fun createTag(tagCreateRequest: TagModel): TagModel {
        val tag: Tag = tagCreateRequest.toEntity()
        val newTag: Tag = tagRepository.save(tag)
        return newTag.fromEntity()
    }

    override fun updateTagById(tagId: Long, tagUpdateRequest: TagModel): TagModel {
        val tag: Tag = tagRepository.getById(tagId)

        val updateInfo: Tag = tagUpdateRequest.toEntity()
        tag.tagName = updateInfo.tagName
        tag.description = updateInfo.description

        val updatedTag: Tag = tagRepository.save(tag)
        return updatedTag.fromEntity()
    }

    override fun deleteTagById(tagId: Long) {
        val tag: Tag = tagRepository.getById(tagId)
        tagRepository.delete(tag)
    }

    override fun listTags(): List<TagModel> {
        val tags: List<Tag> = tagRepository.findAll()
        return tags.map { tag -> tag.fromEntity() }
    }
}
