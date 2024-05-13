package com.ropaformal.ecommerceropaformal.domain.clases

import com.ropaformal.ecommerceropaformal.persistence.entity.Personas
import com.ropaformal.ecommerceropaformal.persistence.entity.UserEntity
import org.springframework.security.crypto.password.PasswordEncoder

/**
 * Esta clase permite tener patrones de diseño orientados al dominio
 */

data class User(
  val username: String?,
  val password: String?,
  val id_persona: Int?
) {

  /**
   * Este metodo convierte de clase user a
   * UserEntity para que guarde correctamente en la base de datos
   */
  fun toEntity(passwordEncoder: PasswordEncoder, personas:Personas): UserEntity {
    return UserEntity(
      username = this.username,
      password = passwordEncoder.encode(this.password),
      locked = false,
      disabled = false,
      roles = emptyList(),
      personas = personas
    )
  }
}
