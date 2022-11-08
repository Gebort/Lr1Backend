package edu.festu.ivankuznetsov.springsamplebo941pia.controller

import edu.festu.ivankuznetsov.springsamplebo941pia.entity_dto.AuthorEntity
import edu.festu.ivankuznetsov.springsamplebo941pia.service.AuthorService
import edu.festu.ivankuznetsov.springsamplebo941pia.service.BookService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class AuthorController(
    private val authorService: AuthorService,
    private val bookService: BookService,
    ) {

    @GetMapping("/authors")
    fun getAuthors(model: Model): String {
        model["authors"] = authorService.getAll()
        return "authors"
    }

    @GetMapping("/authors/{authorId}")
    fun getAuthorId(@PathVariable authorId: String, model: Model): String {
        model["author"] = authorService.getById(authorId.toLong())
        return "author_page"
    }

    @GetMapping("/authors/edit/{authorId}")
    fun editAuthor(@PathVariable authorId: Long, model: Model): String{
        model["author"] = authorService.getById(authorId)
        model["books_list"] = bookService.getAll()
        return "author_edit"
    }

    @PostMapping("/authors/edit")
    fun editAuthorPost(actor: AuthorEntity): String{
        authorService.save(actor)
        return "redirect:/authors"
    }

    @GetMapping("/authors/create")
    fun createAuthor(model: Model): String{
        model["author"] = AuthorEntity()
        model["books_list"] = bookService.getAll()
        return "author_edit"
    }

    @PostMapping("/author/create")
    fun createAuthorPost(author: AuthorEntity): String{
        authorService.save(author)
        return "redirect:/authors"
    }

    @GetMapping("/authors/delete/{authorId}")
    fun deleteAuthor(@PathVariable authorId: Long): String {
        val author = authorService.getById(authorId)
        authorService.delete(author)
        return "redirect:/authors"
    }

}