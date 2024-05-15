package com.ropaformal.ecommerceropaformal.service

import com.ropaformal.ecommerceropaformal.persistence.entity.CarroCompProduEntity
import com.ropaformal.ecommerceropaformal.persistence.repository.CarComProRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CarComProService {

  @Autowired
  private lateinit var carComProRepository: CarComProRepository

  fun getAll(): List<CarroCompProduEntity> {
    return this.carComProRepository.findAll().toList()
  }
}
