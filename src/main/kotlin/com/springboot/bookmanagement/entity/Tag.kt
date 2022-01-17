package com.springboot.bookmanagement.entity

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import javax.persistence.*

@Entity
@Table(name = "tag")
data class Tag(
//    tag: id, tagName, books(set), description

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,
    @Column(name = "tag_name")
    var tagName: String,
    var description: String,

    @ManyToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL], mappedBy = "tags")
    @JsonIgnoreProperties("tags")
    var books: Set<Book> = mutableSetOf()
)