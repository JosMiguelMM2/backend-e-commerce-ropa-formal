package com.ropaformal.ecommerceropaformal.persistence.repository

import com.ropaformal.ecommerceropaformal.persistence.entity.ProductoEntity
import org.springframework.data.repository.CrudRepository

interface ProductoRepository:CrudRepository<ProductoEntity, Int>{
}
