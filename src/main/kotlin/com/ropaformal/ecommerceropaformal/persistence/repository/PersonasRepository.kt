package com.ropaformal.ecommerceropaformal.persistence.repository

import com.ropaformal.ecommerceropaformal.persistence.entity.Personas
import org.springframework.data.repository.CrudRepository

interface PersonasRepository:CrudRepository<Personas, Int> {
}
