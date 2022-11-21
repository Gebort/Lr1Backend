package edu.festu.ivankuznetsov.springsamplebo941pia.service

import edu.festu.ivankuznetsov.springsamplebo941pia.entity.BuyerEntity
import edu.festu.ivankuznetsov.springsamplebo941pia.repository.BuyerRepository
import org.springframework.stereotype.Service

@Service
class BuyerServiceImpl(
    private val buyerRepository: BuyerRepository
): BuyerService {

    override fun getAll(): List<BuyerEntity> {
        return buyerRepository.findAll()
    }

}