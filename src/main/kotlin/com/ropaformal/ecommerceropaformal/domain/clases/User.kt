package com.ropaformal.ecommerceropaformal.domain.clases

import com.ropaformal.ecommerceropaformal.persistence.entity.UserEntity
import org.springframework.security.crypto.password.PasswordEncoder

/**
 * Esta clase permite tener patrones de diseño orientados al dominio
 */

data class User(
  val username: String?,
  val name:String?,
  val email: String?,
  val password: String?
) {

  /**
   * Este metodo convierte de clase user a
   * UserEntity para que guarde correctamente en la base de datos
   */
  fun toEntity(passwordEncoder: PasswordEncoder): UserEntity {

    return UserEntity(
      username = this.username,
      name = this.name,
      password = passwordEncoder.encode(this.password),
      email = this.email,
      locked = false,
      disabled = false,
      roles = emptyList()
    )
  }
}
