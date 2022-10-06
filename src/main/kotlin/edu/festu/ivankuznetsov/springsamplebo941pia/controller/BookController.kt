package edu.festu.ivankuznetsov.springsamplebo941pia.controller

import edu.festu.ivankuznetsov.springsamplebo941pia.service.AuthorService
import edu.festu.ivankuznetsov.springsamplebo941pia.service.BookService
import edu.festu.ivankuznetsov.springsamplebo941pia.service.GenreService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

/**
 * контроллер оценок
 * */
@Controller
class BookController(
    private val bookService: BookService,
    private val authorService: AuthorService,
    private val genreService: GenreService
) {

    @GetMapping("/books")
    fun getBooks(model: Model): String {
        model["books"] = bookService.getAll()
        return "books"
    }
    @GetMapping("/books/{genreTitle}")
    fun getBooks(@PathVariable genreTitle: String, model: Model): String {
        val genre = genreService.findByTitle(genreTitle)
        model["books"] = bookService.getAllByGenre(genre)
        return "books"
    }
    @GetMapping("/authors")
    fun getAuthors(model: Model): String {
        model["authors"] = authorService.getAll()
        return "authors"
    }
       @GetMapping("/rating/{bookId}")
    fun getBookRating(@PathVariable bookId: String, model: Model): String {
        model["book"] = bookService.getById(bookId.toLong())
        return "books_rating"
    }
    @GetMapping("/genres")
    fun getGenres(model: Model): String {
        model["genres"] = genreService.findAll()
        return "genres"
    }


}
