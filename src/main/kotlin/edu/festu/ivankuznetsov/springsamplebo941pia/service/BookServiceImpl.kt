package edu.festu.ivankuznetsov.springsamplebo941pia.service

import edu.festu.ivankuznetsov.springsamplebo941pia.entity_dto.BookEntity
import edu.festu.ivankuznetsov.springsamplebo941pia.repository.BookRepository
import edu.festu.ivankuznetsov.springsamplebo941pia.repository.RatingRepository
import org.springframework.stereotype.Service

@Service
class BookServiceImpl(
    private val bookRepository: BookRepository,
    private val ratingRepository: RatingRepository
    ): BookService {

    override fun getAll(): List<BookEntity> {
        return bookRepository.findAll()
    }
}
