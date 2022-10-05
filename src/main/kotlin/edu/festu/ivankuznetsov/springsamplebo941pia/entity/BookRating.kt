package edu.festu.ivankuznetsov.springsamplebo941pia.entity

import javax.persistence.*


@Entity
class BookRating(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "rating_id", nullable = false)
    val ratingId: Long? = null,

    @ManyToOne
    @MapsId("buyerId")
    @JoinColumn(name = "buyer_id")
    val buyer: BuyerEntity? = null,

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    val book: BookEntity? = null,

    //from 1 to 5
    val rating: Int = 1,
)