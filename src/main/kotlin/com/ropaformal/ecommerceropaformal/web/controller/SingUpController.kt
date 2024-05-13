package com.ropaformal.ecommerceropaformal.web.controller


import com.ropaformal.ecommerceropaformal.domain.clases.User
import com.ropaformal.ecommerceropaformal.persistence.entity.UserEntity
import com.ropaformal.ecommerceropaformal.persistence.entity.UserRoleEntity
import com.ropaformal.ecommerceropaformal.service.PersonaService
import com.ropaformal.ecommerceropaformal.service.UserRoleService
import com.ropaformal.ecommerceropaformal.service.UserService
import com.ropaformal.ecommerceropaformal.service.dto.UserPersonasDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime


/**
 * Esta clase permite Crear un nuevo usuario y cambiar contraseña
 */

@RestController
@RequestMapping("/e/sing")
class SingUpController {
  @Autowired
  private lateinit var userService: UserService

  @Autowired
  private lateinit var personaService: PersonaService

  @Autowired
  private lateinit var userRoleService: UserRoleService

  /**
   * Este metodo crea un usuario
   */
  @PostMapping("/up")
  fun save(@RequestBody userPersonasDTO: UserPersonasDTO): ResponseEntity<User> {

    /**
     * Se comprueba si exista el usuario
     */
    return if (userPersonasDTO.user.username?.let { this.userService.budcarId(it) } == true) {
      ResponseEntity.badRequest().build()
    } else {
      /**
       * Si no existe debe primero guardar a la personas y luego al usuario
       */
      val savedPersona = this.personaService.save(userPersonasDTO.personas)
      val userWithPersona = userPersonasDTO.user.copy(id_persona = savedPersona.idPersonas)
      val envio = this.userService.NewUser(userWithPersona)

      /**
       * Se inserta el rol del usuario por defecto que va a ser user
       * Solo el administrador puede cambiar el rol del usuario
       */
      val userWithNewIdUserRole = envio.username
      val userEntityOptional = userWithNewIdUserRole?.let { this.userService.busdcarId(it) }
      val userEntity = userEntityOptional?.orElse(null)
      val value = UserRoleEntity(
        idUserRole = 0,
        role = "USER",
        granteDate = LocalDateTime.now(),
        user = userEntity
      )
      this.userRoleService.save(value)

      ResponseEntity.ok(envio)
    }
  }

  /**
   * Cambio de contraseña
   */

  @PatchMapping("/change")
  @PreAuthorize("isAuthenticated()")            //solo se puede acceder si se esta autenticado
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
