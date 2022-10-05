package edu.festu.ivankuznetsov.springsamplebo941pia.entity

import javax.persistence.*

@Entity
@Table(name = "book")
class BookEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id", nullable = false)
    val bookId: Long? = null,

    val title: String? = null,

    @ManyToOne(cascade = [CascadeType.ALL])
    @MapsId("genreId")
    @JoinColumn(name = "genre_id")
    val genre: GenreEntity? = null,

    @OneToMany(mappedBy = "book")
    val authors: Set<AuthorBook> = setOf(),

    @OneToMany(mappedBy = "book")
    val buyers: Set<BookRating> = setOf(),
)