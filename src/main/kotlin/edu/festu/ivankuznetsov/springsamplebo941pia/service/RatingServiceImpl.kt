package edu.festu.ivankuznetsov.springsamplebo941pia.service

import edu.festu.ivankuznetsov.springsamplebo941pia.entity.BookRating
import edu.festu.ivankuznetsov.springsamplebo941pia.repository.RatingRepository
import org.springframework.stereotype.Service

@Service
class RatingServiceImpl(
    private val repository: RatingRepository
): RatingService {
    override fun save(rating: BookRating) {
        repository.save(rating)
    }

    override fun findAll(): List<BookRating> {
        return repository.findAll()
    }

    override fun getById(id: Long): BookRating {
        return repository.findById(id).orElseThrow()
    }

    override fun delete(rating: BookRating) {
        repository.delete(rating)
    }
}