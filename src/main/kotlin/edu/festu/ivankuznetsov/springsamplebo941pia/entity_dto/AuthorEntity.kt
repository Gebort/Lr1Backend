package edu.festu.ivankuznetsov.springsamplebo941pia.entity_dto

import javax.persistence.*

@Entity
@Table(name = "author")
class AuthorEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "author_id", nullable = false)
    val authorId: Long? = null,

    val firstName: String? = null,

    val lastName: String? = null,

    @ManyToMany(
        fetch = FetchType.LAZY,
        cascade = [ CascadeType.PERSIST],
    )
    @JoinTable(
        name = "author_book",
        joinColumns = [JoinColumn(name = "author_id")],
        inverseJoinColumns = [JoinColumn(name = "book_id")],
    )
    val books: List<BookEntity> = listOf(),
) {

}