package com.ropaformal.ecommerceropaformal.web.controller


import com.ropaformal.ecommerceropaformal.domain.clases.User
import com.ropaformal.ecommerceropaformal.persistence.entity.UserEntity
import com.ropaformal.ecommerceropaformal.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


/**
 * Esta clase permite Crear un nuevo usuario y cambiar contraseña
 */

@RestController
@RequestMapping("/e/sing")
class SingUpController {
  @Autowired
  private lateinit var userService: UserService

  /**
   * Este metodo crea un usuario
   */
  @PostMapping("/up")
  fun save(@RequestBody user: User): ResponseEntity<User> {
    return if (user.username?.let { this.userService.budcarId(it) } == true) {
      ResponseEntity.badRequest().build()
    } else {
      val envio = this.userService.NewUser(user)
      ResponseEntity.ok(envio)
    }
  }

  /**
   * Cambio de contraseña
   */

  @PatchMapping("/change")
  @PreAuthorize("isAuthenticated()") //solo se puede acceder si se esta autenticado
  fun cambioPassword(@RequestBody newPassword: Map<String, String>): ResponseEntity<UserEntity> {
    val newPasswordf = newPassword["newPassword"]
    if (newPasswordf == null) {
      return ResponseEntity.badRequest().build()
    } else {
      val userName = SecurityContextHolder.getContext().authentication.name
      this.userService.UpPassword(userName, newPasswordf)
      return ResponseEntity.ok().build()
    }

  }
}
