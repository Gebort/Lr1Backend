package edu.festu.ivankuznetsov.springsamplebo941pia.service

import edu.festu.ivankuznetsov.springsamplebo941pia.entity.AuthorEntity

interface AuthorService {
    fun getAll(): List<AuthorEntity>
}