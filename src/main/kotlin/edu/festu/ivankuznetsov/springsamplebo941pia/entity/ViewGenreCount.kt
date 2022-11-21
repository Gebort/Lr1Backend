package edu.festu.ivankuznetsov.springsamplebo941pia.entity

import org.hibernate.annotations.Immutable
import org.hibernate.annotations.Subselect
import org.hibernate.annotations.Synchronize
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@Immutable
@Subselect("SELECT g.GENRE_ID as id, g.GENRE as genre, COUNT(b.BOOK_ID) as count FROM GENRE g LEFT JOIN BOOK b ON g.GENRE_ID = b.GENRE_GENRE_ID GROUP BY g.GENRE_ID, g.GENRE")
@Synchronize("GENRE_ENTITY", "BOOK_ENTITY")
data class ViewGenreCount(
    @Id val id: Long = 0,
    @Column val genre: String = "",
    @Column val count: Int = 0
)