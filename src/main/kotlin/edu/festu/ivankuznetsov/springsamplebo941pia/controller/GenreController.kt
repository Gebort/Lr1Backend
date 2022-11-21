package edu.festu.ivankuznetsov.springsamplebo941pia.controller

import edu.festu.ivankuznetsov.springsamplebo941pia.entity.GenreEntity
import edu.festu.ivankuznetsov.springsamplebo941pia.service.BookService
import edu.festu.ivankuznetsov.springsamplebo941pia.service.GenreCountService
import edu.festu.ivankuznetsov.springsamplebo941pia.service.GenreService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class GenreController(
    private val bookService: BookService,
    private val genreService: GenreService,
    private val genreCountService: GenreCountService
) {
    @GetMapping("/books/{genreTitle}")
    fun getBooks(@PathVariable genreTitle: String, model: Model): String {
        genreService.findByTitle(genreTitle).let {
            model["genre"] = it
            model["books"] = bookService.getAllByGenre(it)
        }
        return "books_genre"
    }

    @GetMapping("/genres")
    fun getGenres(model: Model): String {
        model["genres"] = genreCountService.getAll()
        return "genres"
    }
    @GetMapping("/genres/create")
    fun createGenre(model: Model): String {
        model["genre"] = GenreEntity()
        return "genre_edit"
    }

    @PostMapping("/genres/create")
    fun createGenreSave(genre: GenreEntity): String{
        genreService.save(genre)
        return "redirect:/genres"
    }

    @GetMapping("/genres/edit/{idGenre}")
    fun editGenre(@PathVariable idGenre: Long, model: Model): String{
        model["genre"] = genreService.getById(idGenre)
        return "genre_edit"
    }

    @PostMapping("/genres/edit")
    fun editGenreSave(genre: GenreEntity): String{
        genreService.save(genre)
        return "redirect:/genres"
    }

    @GetMapping("/genres/delete/{idGenre}")
    fun deleteGenre(@PathVariable idGenre: Long): String {
        val genre = genreService.getById(idGenre)
        genreService.delete(genre)
        return "redirect:/genres"
    }

}