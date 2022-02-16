package com.springboot.bookmanagement.controller

import com.springboot.bookmanagement.controller.dto.BookDto
import com.springboot.bookmanagement.controller.dto.fromModel
import com.springboot.bookmanagement.controller.dto.toModel
import com.springboot.bookmanagement.repository.entity.Book
import com.springboot.bookmanagement.service.impl.BookServiceImpl
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookController(private val bookService: BookServiceImpl) {

    @GetMapping
    fun listBooks(
            @RequestParam(value = "pageNo", defaultValue = "1", required = false) pageNo: Int,
            @RequestParam(value = "pageSize", defaultValue = "10", required = false) pageSize: Int,
    ): List<BookDto> {
        return bookService.listBooks(pageNo, pageSize).map { book -> book.fromModel() }
    }

    @GetMapping("/{id}")
    fun getBookById(@PathVariable("id") bookId: Long): BookDto {
        return bookService.getBookById(bookId).fromModel()
    }

    @PostMapping
    fun createBook(@RequestBody bookCreateRequest: BookDto): BookDto {
        val bookModel = bookCreateRequest.toModel()
        val createBook = bookService.createBook(bookModel)
        return createBook.fromModel()
    }

    @PutMapping("/{id}")
    fun updateBookById(@PathVariable("id") bookId: Long, @RequestBody bookUpdateRequest: BookDto): BookDto {
        val bookModel = bookUpdateRequest.toModel()
        return bookService.updateBookById(bookId, bookModel).fromModel()
    }

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
    fun addTagToBook(@PathVariable("id") bookId: Long, @PathVariable("tagId") tagId: Long): BookDto {
        return bookService.addTagToBook(bookId, tagId).fromModel()
    }

    @DeleteMapping("/{id}/tags/{tagId}")
    fun removeTagFromBook(@PathVariable("id") bookId: Long, @PathVariable tagId: Long): BookDto {
        return bookService.removeTagFromBook(bookId, tagId).fromModel()
    }
}