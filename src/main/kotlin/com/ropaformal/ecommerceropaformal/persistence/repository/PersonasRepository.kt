package com.ropaformal.ecommerceropaformal.persistence.repository

import com.ropaformal.ecommerceropaformal.persistence.entity.PersonasEntity
import org.springframework.data.repository.CrudRepository

interface PersonasRepository:CrudRepository<PersonasEntity, Int> {
}
