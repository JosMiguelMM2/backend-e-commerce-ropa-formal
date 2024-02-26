package com.ropaformal.ecommerceropaformal.service

import com.ropaformal.ecommerceropaformal.domain.clases.User
import com.ropaformal.ecommerceropaformal.persistence.entity.UserEntity
import com.ropaformal.ecommerceropaformal.persistence.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService {
  @Autowired
  private lateinit var userRepository: UserRepository

  @Autowired
  private lateinit var passwordEncoder: PasswordEncoder

  fun NewUser(user: User): User {
    val userEntity = user.toEntity(passwordEncoder)
    this.userRepository.save(userEntity)
    return user
  }

  fun budcarId(usename: String): Boolean {
    return this.userRepository.existsById(usename)
  }

  fun busdcarId(id: String): Optional<UserEntity> {
    return this.userRepository.findById(id)
  }

  fun UpPassword(id: String, newPassword: String): UserEntity {
    val resultado = busdcarId(id)
    val userEntity = resultado.get()
    return run {
      userEntity.password = passwordEncoder.encode(newPassword)
      this.userRepository.save(userEntity)
    }
  }
}
