package edu.festu.ivankuznetsov.springsamplebo941pia.service

import edu.festu.ivankuznetsov.springsamplebo941pia.entity.BookEntity

interface BookService {
    fun getAll(): List<BookEntity>
}
