package com.ropaformal.ecommerceropaformal.web.controller

import com.ropaformal.ecommerceropaformal.domain.clases.User
import com.ropaformal.ecommerceropaformal.persistence.entity.UserEntity
import com.ropaformal.ecommerceropaformal.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/e/sing")
class SingUpController {
  @Autowired
  private lateinit var userService: UserService

  @PostMapping("/up")
  fun save(@RequestBody user: User): ResponseEntity<User> {
    return if (user.username?.let { this.userService.budcarId(it) } == true) {
      ResponseEntity.badRequest().build()
    } else {
      val envio = this.userService.NewUser(user)
      ResponseEntity.ok(envio)
    }
  }

  @PutMapping("/change")
  @PreAuthorize("isAuthenticated()")
  fun cambioPassword(@RequestBody newPassword: String): ResponseEntity<UserEntity> {
    val userName = SecurityContextHolder.getContext().authentication.name
    val user = this.userService.busdcarId(userName)
    return if (user == null) {
      return ResponseEntity.notFound().build()
    } else {
      return ResponseEntity.ok(this.userService.UpPassword(userName, newPassword))
    }
  }
}
