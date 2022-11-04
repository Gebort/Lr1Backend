package edu.festu.ivankuznetsov.springsamplebo941pia.service

import edu.festu.ivankuznetsov.springsamplebo941pia.entity_dto.GenreEntity
import edu.festu.ivankuznetsov.springsamplebo941pia.repository.BookRepository
import edu.festu.ivankuznetsov.springsamplebo941pia.repository.GenreRepository
import org.springframework.data.domain.Example
import org.springframework.stereotype.Service

@Service
class GenreServiceImpl(
    private val genreRepository: GenreRepository,
): GenreService {
    override fun save(genre: GenreEntity) {
        genreRepository.save(genre)
    }

    override fun findAll(): List<GenreEntity> {
        return genreRepository.findAll()
    }

    override fun findByTitle(title: String): GenreEntity {
        return genreRepository.findOne(Example.of(GenreEntity(genre = title))).orElseThrow()
    }

    override fun getById(id: Long): GenreEntity {
        return genreRepository.findById(id).orElseThrow()
    }

    override fun delete(genre: GenreEntity) {
        genreRepository.delete(genre)
    }
}