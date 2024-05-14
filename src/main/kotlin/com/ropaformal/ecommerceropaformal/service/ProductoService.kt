package com.ropaformal.ecommerceropaformal.service

import com.ropaformal.ecommerceropaformal.persistence.entity.ProductoEntity
import com.ropaformal.ecommerceropaformal.persistence.repository.ProductoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductoService {
  @Autowired
  private lateinit var productoRepository: ProductoRepository

  fun getAllProductos():Set<ProductoEntity>{
    return this.productoRepository.findAll().toSet()
  }
}
