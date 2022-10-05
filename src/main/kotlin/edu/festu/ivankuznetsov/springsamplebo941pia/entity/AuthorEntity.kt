package edu.festu.ivankuznetsov.springsamplebo941pia.entity

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

    @OneToMany(mappedBy = "author")
    val books: Set<AuthorBook> = setOf(),
)