package edu.festu.ivankuznetsov.springsamplebo941pia.service

import edu.festu.ivankuznetsov.springsamplebo941pia.entity.BookEntity
import edu.festu.ivankuznetsov.springsamplebo941pia.entity.GenreEntity

interface BookService {
    fun getAll(): List<BookEntity>
    fun getById(id: Long): BookEntity
    fun getAllByGenre(genre: GenreEntity): List<BookEntity>
    fun delete(book: BookEntity)
    fun save(book: BookEntity)
}
