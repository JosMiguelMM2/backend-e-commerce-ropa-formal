package com.ropaformal.ecommerceropaformal.service

import com.ropaformal.ecommerceropaformal.persistence.entity.CarroCompraEntity
import com.ropaformal.ecommerceropaformal.persistence.repository.CarCompRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CarCompService {
  @Autowired
  private lateinit var carCompRepository: CarCompRepository

  fun getAll(): List<CarroCompraEntity> {
    return this.carCompRepository.findAll().toList()
  }
}
