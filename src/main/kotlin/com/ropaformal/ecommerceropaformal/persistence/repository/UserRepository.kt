package com.ropaformal.ecommerceropaformal.persistence.repository

import com.ropaformal.ecommerceropaformal.persistence.entity.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserEntity, String> {
}
