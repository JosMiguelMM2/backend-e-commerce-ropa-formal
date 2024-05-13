package com.ropaformal.ecommerceropaformal.persistence.repository

import com.ropaformal.ecommerceropaformal.persistence.entity.UserRoleEntity
import org.springframework.data.repository.CrudRepository

interface UserRoleRepository : CrudRepository<UserRoleEntity, Int> {
}
