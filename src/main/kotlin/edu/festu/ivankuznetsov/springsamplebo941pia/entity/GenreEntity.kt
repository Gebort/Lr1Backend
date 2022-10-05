package edu.festu.ivankuznetsov.springsamplebo941pia.entity

import javax.persistence.*

@Entity
@Table(name = "genre")
class GenreEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "genre_id", nullable = false)
    val genreId: Long? = null,

    val genre: String = "",

//    @OneToMany(cascade = [CascadeType.ALL], mappedBy = "genre")
//    val books: Set<BookEntity> = setOf()


)