package edu.festu.ivankuznetsov.springsamplebo941pia.entity

import javax.persistence.*

@Entity
@Table(name = "buyer")
class BuyerEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "buyer_id", nullable = false)
    val buyerId: Long? = null,

    val firstName: String? = null,

    val lastName: String? = null,

    @OneToMany(mappedBy = "buyer")
    val books: Set<BookRating> = setOf(),
)