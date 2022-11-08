package edu.festu.ivankuznetsov.springsamplebo941pia.service

import edu.festu.ivankuznetsov.springsamplebo941pia.entity_dto.ViewGenreCount
import edu.festu.ivankuznetsov.springsamplebo941pia.repository.GenreCountRepository
import org.springframework.stereotype.Service

@Service
class GenreCountServiceImpl(
    private val repository: GenreCountRepository
): GenreCountService {

    override fun getAll(): List<ViewGenreCount> {
        return repository.findAll()
    }


}