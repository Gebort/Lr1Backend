package edu.festu.ivankuznetsov.springsamplebo941pia.service

import edu.festu.ivankuznetsov.springsamplebo941pia.entity_dto.BookEntity
import edu.festu.ivankuznetsov.springsamplebo941pia.entity_dto.GenreEntity

interface BookService {
    fun getAll(): List<BookEntity>
    fun getById(id: Long): BookEntity
    fun getAllByGenre(genre: GenreEntity): List<BookEntity>
}
