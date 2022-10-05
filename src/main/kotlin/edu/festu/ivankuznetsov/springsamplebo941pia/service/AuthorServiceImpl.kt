package edu.festu.ivankuznetsov.springsamplebo941pia.service

import edu.festu.ivankuznetsov.springsamplebo941pia.entity.AuthorEntity
import edu.festu.ivankuznetsov.springsamplebo941pia.entity.BookEntity
import edu.festu.ivankuznetsov.springsamplebo941pia.repository.AuthorRepository
import edu.festu.ivankuznetsov.springsamplebo941pia.repository.BookRepository
import edu.festu.ivankuznetsov.springsamplebo941pia.repository.GenreRepository
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(
    private val authorRepository: AuthorRepository,
): AuthorService {

    override fun getAll(): List<AuthorEntity> {
        return authorRepository.findAll()
    }

}