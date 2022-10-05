package edu.festu.ivankuznetsov.springsamplebo941pia.repository

import edu.festu.ivankuznetsov.springsamplebo941pia.entity_dto.*
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository: JpaRepository<BookEntity, Long>

@Repository
interface AuthorRepository: JpaRepository<AuthorEntity, Long>

@Repository
interface RatingRepository: JpaRepository<BookRating, Long>

@Repository
interface BuyerRepository: JpaRepository<BuyerEntity, Long>

@Repository
interface GenreRepository: JpaRepository<GenreEntity, Long>
