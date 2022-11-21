package edu.festu.ivankuznetsov.springsamplebo941pia.controller

import edu.festu.ivankuznetsov.springsamplebo941pia.entity.BookRating
import edu.festu.ivankuznetsov.springsamplebo941pia.service.BookService
import edu.festu.ivankuznetsov.springsamplebo941pia.service.BuyerService
import edu.festu.ivankuznetsov.springsamplebo941pia.service.RatingService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping

@Controller
class RatingController(
    private val ratingService: RatingService,
    private val bookService: BookService,
    private val buyerService: BuyerService,
) {

    @GetMapping("/rating/{bookId}")
    fun getBookRating(@PathVariable bookId: String, model: Model): String {
        model["book"] = bookService.getById(bookId.toLong())
        return "books_rating"
    }

    @GetMapping("/rating/create")
    fun createRating(model: Model): String {
        model["rating"] = BookRating()
        model["books_list"] = bookService.getAll()
        model["buyers_list"] = buyerService.getAll()
        return "rating_edit"
    }

    @PostMapping("/rating/create")
    fun createRatingPost(rating: BookRating): String{
        ratingService.save(rating)
        return "redirect:/rating/${rating.book?.bookId}"
    }

    @GetMapping("/rating/edit/{idRating}")
    fun editRating(@PathVariable idRating: String, model: Model): String{
        model["rating"] = ratingService.getById(idRating.toLong())
        model["books_list"] = bookService.getAll()
        model["buyers_list"] = buyerService.getAll()
        return "rating_edit"
    }

    @PostMapping("/rating/edit")
    fun editRatingPost(rating: BookRating): String{
        ratingService.save(rating)
        return "redirect:/rating/${rating.book?.bookId}"
    }

    @GetMapping("/rating/delete/{idRating}")
    fun deleteRating(@PathVariable idRating: Long): String {
        val rating = ratingService.getById(idRating)
        ratingService.delete(rating)
        return "redirect:/rating/${rating.book?.bookId}"
    }

}