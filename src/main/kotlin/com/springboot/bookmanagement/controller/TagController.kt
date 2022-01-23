package com.springboot.bookmanagement.controller

import com.springboot.bookmanagement.controller.dto.TagDto
import com.springboot.bookmanagement.controller.dto.fromModel
import com.springboot.bookmanagement.controller.dto.toModel
import com.springboot.bookmanagement.repository.entity.Tag
import com.springboot.bookmanagement.service.impl.TagServiceImpl
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tags")
class TagController(private val tagService: TagServiceImpl) {

    @GetMapping
    fun listTags(
        @RequestParam(defaultValue = "1") page: Int,
        @RequestParam(defaultValue = "10") size: Int,
        @RequestParam(name = "tagName", required = false) titleName: String
    ): List<Tag> {
        return emptyList()
    }

    @GetMapping("/{tagId}")
    fun getTagById(@PathVariable("tagId") tagId: Long): TagDto = tagService.getTagById(tagId).fromModel()

    @PostMapping
    fun createTag(@RequestBody tagCreateRequest: TagDto): TagDto {
        val tagModel = tagCreateRequest.toModel()
        val createTag = tagService.createTag(tagModel)
        return createTag.fromModel()
    }

    @PutMapping("/{tagId}")
    fun updateTagById(@PathVariable("tagId") tagId: Long, @RequestBody tagUpdateRequest: TagDto): TagDto {
        val tagModel = tagUpdateRequest.toModel()
        return tagService.updateTagById(tagId, tagModel).fromModel()
    }

    @DeleteMapping("/{tagId}")
    fun deleteTagById(@PathVariable("tagId") tagId: Long): Unit = tagService.deleteTagById(tagId)

    @GetMapping("/books/{id}")
    fun getTagsByBookId(
        @PathVariable("id") tagId: Long, @RequestParam(defaultValue = "1") page: Int,
        @RequestParam(defaultValue = "10") size: Int,
        @RequestParam(name = "tagName", required = false) tagName: String
    ): List<Tag> {
        return emptyList()
    }
}