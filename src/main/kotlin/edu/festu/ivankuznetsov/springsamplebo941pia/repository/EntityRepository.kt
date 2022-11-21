package edu.festu.ivankuznetsov.springsamplebo941pia.repository

import edu.festu.ivankuznetsov.springsamplebo941pia.entity.*
import edu.festu.ivankuznetsov.springsamplebo941pia.entity_security.Role
import edu.festu.ivankuznetsov.springsamplebo941pia.entity_security.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import javax.transaction.Transactional

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

@Repository
interface GenreCountRepository: JpaRepository<ViewGenreCount, Long>

@Transactional
@Repository
interface RoleRepository : JpaRepository<Role?, String?>

@Repository
interface UserRepository : JpaRepository<User?, Long?> {
    @Transactional
    @Query("SELECT t FROM accounts t LEFT JOIN FETCH t.roles where t.username = ?1")
    fun findByUsername(username: String?): User?
}