package edu.festu.ivankuznetsov.springsamplebo941pia.service

import edu.festu.ivankuznetsov.springsamplebo941pia.entity_dto.GenreEntity

interface GenreService {
    fun findAll(): List<GenreEntity>
    fun findByTitle(title: String): GenreEntity
}