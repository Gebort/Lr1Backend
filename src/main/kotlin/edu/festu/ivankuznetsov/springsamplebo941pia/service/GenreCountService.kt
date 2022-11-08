package edu.festu.ivankuznetsov.springsamplebo941pia.service

import edu.festu.ivankuznetsov.springsamplebo941pia.entity_dto.ViewGenreCount

interface GenreCountService {

    fun getAll(): List<ViewGenreCount>

}