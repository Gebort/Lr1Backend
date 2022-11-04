package edu.festu.ivankuznetsov.springsamplebo941pia.service

import edu.festu.ivankuznetsov.springsamplebo941pia.entity_dto.AuthorEntity

interface AuthorService {
    fun getAll(): List<AuthorEntity>
    fun getById(authorId: Long): AuthorEntity
    fun save(author: AuthorEntity)
    fun delete(author: AuthorEntity)

}