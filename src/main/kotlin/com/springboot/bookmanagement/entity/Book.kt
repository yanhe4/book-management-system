package com.springboot.bookmanagement.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
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
    var tags: Set<Tag> = mutableSetOf()
)

enum class Status {
    AVAILABLE, CHECKED_OUT
}