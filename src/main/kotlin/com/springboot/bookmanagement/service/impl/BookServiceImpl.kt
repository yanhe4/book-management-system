package com.springboot.bookmanagement.service.impl

import com.springboot.bookmanagement.service.model.BookModel
import com.springboot.bookmanagement.service.model.toEntity
import com.springboot.bookmanagement.repository.entity.Book
import com.springboot.bookmanagement.repository.BookRepository
import com.springboot.bookmanagement.repository.TagRepository
import com.springboot.bookmanagement.repository.entity.Tag
import com.springboot.bookmanagement.service.BookService
import com.springboot.bookmanagement.service.model.fromEntity
import org.springframework.stereotype.Service

@Service
class BookServiceImpl(private val bookRepository: BookRepository, private val tagRepository: TagRepository): BookService {

    override fun getBookById(bookId: Long): BookModel {
        val book: Book = bookRepository.getById(bookId)
        return book.fromEntity()
    }

    override fun createBook(bookModel: BookModel): BookModel {
        // convert model to entity
        val book: Book = bookModel.toEntity()

        val newBook: Book = bookRepository.save(book)

        // convert entity to model
        return newBook.fromEntity()
    }

    override fun updateBookById(bookId: Long, bookModel: BookModel): BookModel {
        // get book by id from the db
        val book: Book = bookRepository.getById(bookId)

        // update book info
        val updateInfo: Book = bookModel.toEntity()
        book.author = updateInfo.author
        book.title = updateInfo.title
        book.status = updateInfo.status
        book.tags = updateInfo.tags

        // save the updated book to db
        val updatedBook: Book = bookRepository.save(book)
        return updatedBook.fromEntity()
    }

    override fun deleteBookById(bookId: Long) {
        // get book by id from the db
        val book: Book = bookRepository.getById(bookId)
        bookRepository.delete(book)
    }

    override fun addTagToBook(bookId: Long, tagId: Long): BookModel {
        // get book and tag by id from the db
        val book: Book = bookRepository.getById(bookId)
        val tag: Tag = tagRepository.getById(tagId)

        book.tags.add(tag)

        return bookRepository.save(book).fromEntity()
    }

    override fun removeTagFromBook(bookId: Long, tagId: Long): BookModel {
        // get book and tag by id from the db
        val book: Book = bookRepository.getById(bookId)
        val tag: Tag = tagRepository.getById(tagId)

        book.tags.remove(tag)

        return bookRepository.save(book).fromEntity()
    }

    override fun listBooks(): List<BookModel> {
        val books: List<Book> = bookRepository.findAll()
        return books.map { book -> book.fromEntity() }
    }
}