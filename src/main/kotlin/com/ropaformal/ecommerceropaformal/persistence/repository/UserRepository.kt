package com.ropaformal.ecommerceropaformal.persistence.repository

import com.ropaformal.ecommerceropaformal.persistence.entity.UserEntity
import org.springframework.data.repository.CrudRepository

/**
 * Esta interface recibe la entidad UserEntity y la llave primaria de esta
 * Esta interface hereda todos los metodos de CrudRepository que con ORM
 * Permite hacer metodos CRUP
 */

interface UserRepository : CrudRepository<UserEntity, String> {
}

