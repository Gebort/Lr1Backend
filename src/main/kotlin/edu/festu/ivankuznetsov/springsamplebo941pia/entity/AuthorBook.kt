package edu.festu.ivankuznetsov.springsamplebo941pia.entity

import javax.persistence.*

@Entity
class AuthorBook(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_book_id", nullable = false)
    val authorBookId: Long? = null,

    @ManyToOne
    @MapsId("authorId")
    @JoinColumn(name = "author_id")
    val author: AuthorEntity? = null,

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    val book: BookEntity? = null,

    )