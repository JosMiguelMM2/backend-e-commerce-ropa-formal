package com.ropaformal.ecommerceropaformal.persistence.repository

import com.ropaformal.ecommerceropaformal.persistence.entity.CarroCompraEntity
import org.springframework.data.repository.CrudRepository

interface CarroCompraRepository:CrudRepository<CarroCompraEntity, Int> {
}
