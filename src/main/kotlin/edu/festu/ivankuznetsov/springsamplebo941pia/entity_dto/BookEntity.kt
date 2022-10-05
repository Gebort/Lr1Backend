package edu.festu.ivankuznetsov.springsamplebo941pia.entity_dto

import java.text.NumberFormat
import java.util.*
import javax.persistence.*
import kotlin.math.roundToInt


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

    @ManyToMany
    @JoinTable(
        name = "author_book",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "author_id")],
    )
    val authors: Set<AuthorEntity> = setOf(),

    @OneToMany(mappedBy = "book")
    val ratings: List<BookRating> = listOf(),
) {

    @delegate:Transient
    val totalRatings: Int by lazy {
        ratings.size
    }

    @delegate:Transient
    val averageRating: Int by lazy {
        ratings
            .asSequence()
            .map { it.rating }
            .filterNotNull()
            .average()
            .roundToInt()
    }

}