package edu.festu.ivankuznetsov.springsamplebo941pia.entity_dto

import javax.persistence.*


@Entity
class BookRating(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rating_id", nullable = false)
    val ratingId: Long? = null,

    @ManyToOne(
        targetEntity = BuyerEntity::class,
        cascade = [ CascadeType.PERSIST],
        fetch = FetchType.LAZY,
    )
    val buyer: BuyerEntity? = null,

    @ManyToOne(
        targetEntity = BookEntity::class,
        cascade = [ CascadeType.PERSIST],
        fetch = FetchType.LAZY,
    )
    val book: BookEntity? = null,

    //from 1 to 5
    val rating: Int? = null,
)