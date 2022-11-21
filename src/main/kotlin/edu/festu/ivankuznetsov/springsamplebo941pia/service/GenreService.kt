package edu.festu.ivankuznetsov.springsamplebo941pia.service

import edu.festu.ivankuznetsov.springsamplebo941pia.entity.GenreEntity

interface GenreService {

    fun save(genre: GenreEntity)
    fun findAll(): List<GenreEntity>
    fun findByTitle(title: String): GenreEntity
    fun getById(id: Long): GenreEntity
    fun delete(genre: GenreEntity)
}