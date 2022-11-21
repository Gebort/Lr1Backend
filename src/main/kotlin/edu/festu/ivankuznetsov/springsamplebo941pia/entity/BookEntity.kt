package edu.festu.ivankuznetsov.springsamplebo941pia.entity

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

    @ManyToOne(
        targetEntity = GenreEntity::class,
        cascade = [ CascadeType.PERSIST],
        fetch = FetchType.LAZY,
    )
    val genre: GenreEntity? = null,

    @ManyToMany
    @JoinTable(
        name = "author_book",
        joinColumns = [JoinColumn(name = "book_id")],
        inverseJoinColumns = [JoinColumn(name = "author_id")],
    )
    val authors: List<AuthorEntity> = listOf(),

    @OneToMany(mappedBy = "book")
    val ratings: List<BookRating> = listOf(),
) {

    @delegate:Transient
    val totalRatings: Int by lazy {
        ratings.size
    }

    @delegate:Transient
    val averageRating: Int by lazy {
        val rat = ratings
            .asSequence()
            .map { it.rating }
            .filterNotNull()
            .average()
        if (rat.isNaN()) 0 else rat.roundToInt()
    }

}