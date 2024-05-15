package com.ropaformal.ecommerceropaformal.persistence.repository

import com.ropaformal.ecommerceropaformal.persistence.entity.CarroCompraEntity
import org.springframework.data.repository.CrudRepository

interface CarCompRepository : CrudRepository<CarroCompraEntity, Int> {

  override fun findAll():List<CarroCompraEntity>
}
