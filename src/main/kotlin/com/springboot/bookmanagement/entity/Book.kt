package com.springboot.bookmanagement.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.springboot.bookmanagement.dto.BookDto
import javax.persistence.*

@Entity
@Table(name = "book")
data class Book(
//    book: id, title, author, status(available, checked-out), addedAt, lastUpdatedAt, tags(set)
//    (book_tag: JoinTable)

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    var title: String,
    var author: String,
    @Enumerated(EnumType.STRING)
    var status: Status,

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinTable(
        name = "book_tag",
        joinColumns = [ JoinColumn(name = "book_id") ],
        inverseJoinColumns = [ JoinColumn(name = "tag_id") ])
    @JsonIgnoreProperties("books")
    var tags: List<Tag> = mutableListOf()
)

enum class Status {
    AVAILABLE, CHECKED_OUT
}

fun Book.toBookDto() = BookDto(
    id = id,
    title = title,
    author = author,
    status = status,
    tags = tags
)