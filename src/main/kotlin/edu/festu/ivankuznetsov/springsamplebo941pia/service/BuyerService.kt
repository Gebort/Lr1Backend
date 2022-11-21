package edu.festu.ivankuznetsov.springsamplebo941pia.service

import edu.festu.ivankuznetsov.springsamplebo941pia.entity.BuyerEntity

interface BuyerService {

    fun getAll(): List<BuyerEntity>

}