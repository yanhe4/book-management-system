package com.springboot.bookmanagement.controller

import com.springboot.bookmanagement.entity.Book
import com.springboot.bookmanagement.service.impl.BookService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/books")
class BookController(private val bookService: BookService) {

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
    fun createBook(@RequestBody bookCreateRequest: Book): Book = bookService.createBook(bookCreateRequest)

    @PutMapping("{id}")
    fun updateBookById(@PathVariable("id") bookId: Long, @RequestBody bookUpdateRequest: Book): Book =
        bookService.updateBookById(bookId, bookUpdateRequest)

    @DeleteMapping("{id}")
    fun deleteBookById(@PathVariable("id") bookId: Long): Unit = bookService.deleteBookById(bookId)

//    @GetMapping("/tags/{tagId}")
//    fun
}