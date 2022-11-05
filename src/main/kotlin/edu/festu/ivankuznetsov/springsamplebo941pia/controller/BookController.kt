package edu.festu.ivankuznetsov.springsamplebo941pia.controller

import edu.festu.ivankuznetsov.springsamplebo941pia.entity_dto.BookEntity
import edu.festu.ivankuznetsov.springsamplebo941pia.service.AuthorService
import edu.festu.ivankuznetsov.springsamplebo941pia.service.BookService
import edu.festu.ivankuznetsov.springsamplebo941pia.service.GenreService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class BookController(
    private val bookService: BookService,
    private val authorService: AuthorService,
    private val genreService: GenreService,
) {
    @GetMapping("/")
    fun getDefault(model: Model): String {
        return getBooks(model)
    }
    @GetMapping("/books")
    fun getBooks(model: Model): String {
        model["books"] = bookService.getAll()
        return "books"
    }

    @GetMapping("/books/edit/{bookId}")
    fun editBook(@PathVariable bookId: Long, model: Model): String{
        model["book"] = bookService.getById(bookId)
        model["authors_list"] = authorService.getAll()
        model["genres_list"] = genreService.findAll()
        return "book_edit"
    }

    @PostMapping("/books/edit")
    fun editBookPost(book: BookEntity): String{
        bookService.save(book)
        return "redirect:/books"
    }

    @GetMapping("/books/create")
    fun createBook(model: Model): String{
        model["book"] = BookEntity()
        model["authors_list"] = authorService.getAll()
        model["genres_list"] = genreService.findAll()
        return "book_edit"
    }

    @PostMapping("/books/create")
    fun createBookPost(book: BookEntity): String{
        bookService.save(book)
        return "redirect:/books"
    }

    @GetMapping("/books/delete/{bookId}")
    fun deleteBook(@PathVariable bookId: Long): String {
        val book = bookService.getById(bookId)
        bookService.delete(book)
        return "redirect:/books"
    }

}
