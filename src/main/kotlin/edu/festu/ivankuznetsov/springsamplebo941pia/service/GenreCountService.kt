package edu.festu.ivankuznetsov.springsamplebo941pia.service

import edu.festu.ivankuznetsov.springsamplebo941pia.entity.ViewGenreCount

interface GenreCountService {

    fun getAll(): List<ViewGenreCount>

}