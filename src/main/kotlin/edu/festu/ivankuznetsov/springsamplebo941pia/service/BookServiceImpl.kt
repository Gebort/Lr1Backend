package edu.festu.ivankuznetsov.springsamplebo941pia.service

import edu.festu.ivankuznetsov.springsamplebo941pia.entity.BookEntity
import edu.festu.ivankuznetsov.springsamplebo941pia.entity.GenreEntity
import edu.festu.ivankuznetsov.springsamplebo941pia.repository.BookRepository
import edu.festu.ivankuznetsov.springsamplebo941pia.repository.RatingRepository
import org.springframework.data.domain.Example
import org.springframework.stereotype.Service

@Service
class BookServiceImpl(
    private val bookRepository: BookRepository,
    private val ratingRepository: RatingRepository
    ): BookService {

    override fun getAll(): List<BookEntity> {
        return bookRepository.findAll()
    }

    override fun getById(id: Long): BookEntity {
        return bookRepository.findById(id).orElseThrow()
    }

    override fun getAllByGenre(genre: GenreEntity): List<BookEntity> {
        return bookRepository.findAll(Example.of(BookEntity(genre = genre)))
    }

    override fun delete(book: BookEntity) {
        bookRepository.delete(book)
    }

    override fun save(book: BookEntity) {
        bookRepository.save(book)
    }
}
