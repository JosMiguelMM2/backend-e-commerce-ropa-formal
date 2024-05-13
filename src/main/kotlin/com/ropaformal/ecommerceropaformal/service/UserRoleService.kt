package com.ropaformal.ecommerceropaformal.service

import com.ropaformal.ecommerceropaformal.persistence.entity.UserRoleEntity
import com.ropaformal.ecommerceropaformal.persistence.repository.UserRoleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserRoleService {
  @Autowired
  private lateinit var userRoleRepository: UserRoleRepository

  fun getUserRoleById(id: Int): Optional<UserRoleEntity> {
    return this.userRoleRepository.findById(id)
  }

  fun save(userRole: UserRoleEntity): UserRoleEntity {
    return this.userRoleRepository.save(userRole)
  }
}
