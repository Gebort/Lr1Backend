package edu.festu.ivankuznetsov.springsamplebo941pia.entity_dto

import javax.persistence.*

@Entity
@Table(name = "genre")
class GenreEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "genre_id", nullable = false)
    val genreId: Long? = null,

    val genre: String = "",

    @OneToMany(
        targetEntity = BookEntity::class,
        cascade = [ CascadeType.ALL],
        fetch = FetchType.LAZY,
        mappedBy="genre"
    )
    var books: MutableList<BookEntity> = mutableListOf()

)