package edu.festu.ivankuznetsov.springsamplebo941pia.service

import edu.festu.ivankuznetsov.springsamplebo941pia.entity.BookEntity
import edu.festu.ivankuznetsov.springsamplebo941pia.entity.GenreEntity
import edu.festu.ivankuznetsov.springsamplebo941pia.repository.BookRepository
import edu.festu.ivankuznetsov.springsamplebo941pia.repository.GenreRepository
import org.springframework.stereotype.Service

@Service
class BookServiceImpl(
    private val bookRepository: BookRepository,
    private val genreRepository: GenreRepository
    ): BookService {

    override fun getAll(): List<BookEntity> {
        return bookRepository.findAll()
    }

}
