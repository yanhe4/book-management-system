package com.springboot.bookmanagement.controller

import com.springboot.bookmanagement.dto.BookDto
import com.springboot.bookmanagement.entity.Book
import com.springboot.bookmanagement.service.impl.BookServiceImpl
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookController(private val bookService: BookServiceImpl) {

    @GetMapping
    fun listBooks(
        @RequestParam(defaultValue = "1") page: Int,
        @RequestParam(defaultValue = "10") size: Int,
        @RequestParam(name = "title", required = false) title: String
    ): List<Book> {
        return emptyList()
    }

    @GetMapping("/{id}")
    fun getBookById(@PathVariable("id") bookId: Long): Book = bookService.getBookById(bookId)

    @PostMapping
    fun createBook(@RequestBody bookCreateRequest: BookDto): BookDto = bookService.createBook(bookCreateRequest)

    @PutMapping("/{id}")
    fun updateBookById(@PathVariable("id") bookId: Long, @RequestBody bookUpdateRequest: Book): Book =
        bookService.updateBookById(bookId, bookUpdateRequest)

    @DeleteMapping("/{id}")
    fun deleteBookById(@PathVariable("id") bookId: Long): Unit = bookService.deleteBookById(bookId)

    @GetMapping("/tags/{tagId}")
    fun getBooksByTagId(
        @PathVariable("tagId") tagId: Long, @RequestParam(defaultValue = "1") page: Int,
        @RequestParam(defaultValue = "10") size: Int,
        @RequestParam(name = "title", required = false) title: String
    ): List<Book> {
        return emptyList()
    }

    @PutMapping("/{id}/tags/{tagId}")
    fun addTagToBook(@PathVariable("id") bookId: Long, @PathVariable("tagId") tagId: Long): Book =
        bookService.addTagToBook(bookId, tagId)

    @DeleteMapping("/{id}/tags/{tagId}")
    fun removeTagFromBook(@PathVariable("id") bookId: Long, @PathVariable tagId: Long): Book =
        bookService.removeTagFromBook(bookId, tagId)
}