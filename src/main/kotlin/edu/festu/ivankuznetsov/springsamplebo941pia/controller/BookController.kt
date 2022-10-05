package edu.festu.ivankuznetsov.springsamplebo941pia.controller

import edu.festu.ivankuznetsov.springsamplebo941pia.service.AuthorService
import edu.festu.ivankuznetsov.springsamplebo941pia.service.BookService
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
) {

    @GetMapping("/")
    fun getBooks(model: Model): String {
        model["books"] = bookService.getAll()
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


}
