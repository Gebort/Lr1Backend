package edu.festu.ivankuznetsov.springsamplebo941pia.service

import edu.festu.ivankuznetsov.springsamplebo941pia.entity.BookRating

interface RatingService {

    fun save(rating: BookRating)
    fun findAll(): List<BookRating>
    fun getById(id: Long): BookRating
    fun delete(rating: BookRating)

}