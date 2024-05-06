package com.ropaformal.ecommerceropaformal.service

import com.ropaformal.ecommerceropaformal.persistence.entity.Prueba
import com.ropaformal.ecommerceropaformal.persistence.repository.PruebaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PruebaService {
  @Autowired
  private lateinit var pruebaRepository: PruebaRepository

  fun getPruebaRepository():Iterable<Prueba> {
    return this.pruebaRepository.findAll()
  }

  fun save(prueba:Prueba): Prueba {
    return this.pruebaRepository.save(prueba)
  }
}
