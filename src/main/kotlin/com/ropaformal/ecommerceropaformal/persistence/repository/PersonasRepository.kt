package com.ropaformal.ecommerceropaformal.persistence.repository

import com.ropaformal.ecommerceropaformal.persistence.entity.PersonaEntity
import org.springframework.data.repository.CrudRepository

interface PersonasRepository:CrudRepository<PersonaEntity, Int> {
}
