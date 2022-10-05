package edu.festu.ivankuznetsov.springsamplebo941pia.service

import edu.festu.ivankuznetsov.springsamplebo941pia.entity_dto.BookEntity

interface BookService {
    fun getAll(): List<BookEntity>
    fun getById(id: Long): BookEntity
}
