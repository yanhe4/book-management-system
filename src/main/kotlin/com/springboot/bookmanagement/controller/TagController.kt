package com.springboot.bookmanagement.controller

import com.springboot.bookmanagement.repository.entity.Tag
import com.springboot.bookmanagement.service.impl.TagService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/tags")
class TagController(private val tagService: TagService) {

    @GetMapping
    fun listTags(
        @RequestParam(defaultValue = "1") page: Int,
        @RequestParam(defaultValue = "10") size: Int,
        @RequestParam(name = "tagName", required = false) titleName: String
    ): List<Tag> {
        return emptyList()
    }

    @GetMapping("/{tagId}")
    fun getTagById(@PathVariable("tagId") tagId: Long): Tag = tagService.getTagById(tagId)

    @PostMapping
    fun createTag(@RequestBody tagCreateRequest: Tag): Tag = tagService.createTag(tagCreateRequest)

    @PutMapping("/{tagId}")
    fun updateTagById(@PathVariable("tagId") tagId: Long, @RequestBody tagUpdateRequest: Tag): Tag =
        tagService.updateTagById(tagId, tagUpdateRequest)

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

    @PutMapping("/{tagId}/books/{id}")
    fun addBookUnderTag(@PathVariable("tagId") tagId: Long, @PathVariable("id") bookId: Long): Tag =
        tagService.addBookUnderTag(tagId, bookId)

    @DeleteMapping("/{tagId}/books/{id}")
    fun removeBookUnderTag(@PathVariable tagId: Long, @PathVariable("id") bookId: Long): Tag =
        tagService.removeBookUnderTag(tagId, bookId)
}