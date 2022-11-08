package edu.festu.ivankuznetsov.springsamplebo941pia.service

import edu.festu.ivankuznetsov.springsamplebo941pia.entity_dto.BuyerEntity

interface BuyerService {

    fun getAll(): List<BuyerEntity>

}