package edu.festu.ivankuznetsov.springsamplebo941pia.service

import edu.festu.ivankuznetsov.springsamplebo941pia.entity_dto.AuthorEntity
import edu.festu.ivankuznetsov.springsamplebo941pia.repository.AuthorRepository
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(
    private val authorRepository: AuthorRepository,
): AuthorService {

    override fun getAll(): List<AuthorEntity> {
        return authorRepository.findAll()
    }

    override fun getById(authorId: Long): AuthorEntity {
        return authorRepository.findById(authorId).orElseThrow()
    }

    override fun save(author: AuthorEntity) {
        authorRepository.save(author)
    }

    override fun delete(author: AuthorEntity) {
        authorRepository.delete(author)
    }

}