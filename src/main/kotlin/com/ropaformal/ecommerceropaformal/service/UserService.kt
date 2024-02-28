package com.ropaformal.ecommerceropaformal.service

import com.ropaformal.ecommerceropaformal.domain.clases.User
import com.ropaformal.ecommerceropaformal.persistence.entity.UserEntity
import com.ropaformal.ecommerceropaformal.persistence.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*


/**
 * Este servicio tiene los metodos necesarios para realizar las validaciones
 */

@Service
class UserService {

  /**
   * Se inicia despues de, el repository
   */
  @Autowired
  private lateinit var userRepository: UserRepository

  /**
   * Se inicia despues de, el medodo para encriptar la contraseña
   */

  @Autowired
  private lateinit var passwordEncoder: PasswordEncoder


  /**
   * Registrar un nuevo usuario
   */
  fun NewUser(user: User): User {
    val userEntity = user.toEntity(passwordEncoder)
    this.userRepository.save(userEntity)
    return user
  }

  /**
   * Buscar el usuario y devolver true o false
   */
  fun budcarId(usename: String): Boolean {
    return this.userRepository.existsById(usename)
  }

  /**
   * Busca por el id y devuelve la entidad
   */
  fun busdcarId(id: String): Optional<UserEntity> {
    return this.userRepository.findById(id)
  }

  /**
   * Modifica la contraseña si el usuario existe
   */

  fun UpPassword(id: String, newPassword: String): UserEntity {
    val resultado = busdcarId(id)
    val userEntity = resultado.get()
    return run {
      userEntity.password = passwordEncoder.encode(newPassword)
      this.userRepository.save(userEntity)
    }
  }
}
