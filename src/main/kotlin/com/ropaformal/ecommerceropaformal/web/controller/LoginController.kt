package com.ropaformal.ecommerceropaformal.web.controller

import com.ropaformal.ecommerceropaformal.service.dto.LoginDto
import com.ropaformal.ecommerceropaformal.web.config.JwtUtil
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

/**
 * Desde esta clase los usuarios podran obtener su token
 */
@RestController
@RequestMapping("/login")
class LoginController {

  /**
   * Se importan las clases que se inician posteriormente
   */
  @Autowired
  private lateinit var authenticationManager: AuthenticationManager

  @Autowired
  private lateinit var jwtUtil: JwtUtil

  @PostMapping()
  fun login(@RequestBody loginDto: LoginDto): ResponseEntity<Void> {
    val login = UsernamePasswordAuthenticationToken(loginDto.username, loginDto.password)
    this.authenticationManager.authenticate(login)
    val jwt: String = this.jwtUtil.crearAlgorithm(login.name)
    return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwt).build()
  }
}
