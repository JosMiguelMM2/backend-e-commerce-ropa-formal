package com.ropaformal.ecommerceropaformal.service

import com.ropaformal.ecommerceropaformal.persistence.entity.UserEntity
import com.ropaformal.ecommerceropaformal.persistence.entity.UserRoleEntity
import com.ropaformal.ecommerceropaformal.persistence.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserSecurityService : UserDetailsService {
  @Autowired
  private lateinit var userRepository: UserRepository
  override fun loadUserByUsername(username: String): UserDetails {
    val userEntity: Optional<UserEntity> = this.userRepository.findById(username)
    val roles: String = userEntity.get().roles.joinToString(",") { it.role ?: "" }
    return User.builder()
      .username(userEntity.get().username)
      .password(userEntity.get().password)
      .roles(roles)
      .accountLocked(userEntity.get().locked)
      .disabled(userEntity.get().disabled)
      .build()
  }

}
